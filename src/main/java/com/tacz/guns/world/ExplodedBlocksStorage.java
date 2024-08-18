package com.tacz.guns.world;

import com.tacz.guns.GunMod;
import com.tacz.guns.api.block.IBulletBreakable;
import com.tacz.guns.mixin.common.IMinecraftServer;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.event.level.LevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.ServerLifecycleHooks;

import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.util.HashMap;

@Mod.EventBusSubscriber(modid = GunMod.MOD_ID)
public class ExplodedBlocksStorage {
    public static HashMap<ResourceKey<Level>, HashMap<Long,Integer>> storage = new HashMap<>();

    public static int damageBlock(Level world, BlockPos pos, int damage){
        if (world.getBlockState(pos).getBlock() instanceof IBulletBreakable){
            damage = ((IBulletBreakable)world.getBlockState(pos).getBlock()).onDamaged(world, pos, damage);
        }
        HashMap<Long, Integer> worldMap = storage.computeIfAbsent(world.dimension(), k -> new HashMap<>());
        int curDamage = worldMap.computeIfAbsent(pos.asLong(), k->getDefaultResistance(world,pos));
        int newDamage = Math.max(0,curDamage-damage);
        worldMap.put(pos.asLong(), newDamage);
        return newDamage;
    }

    public static void removeBlock(Level world, BlockPos pos){
        HashMap<Long, Integer> worldMap = storage.computeIfAbsent(world.dimension(), k -> new HashMap<>());
        worldMap.remove(pos.asLong());
    }

    public static boolean hasBlock(Level world, BlockPos pos){
        HashMap<Long, Integer> worldMap = storage.computeIfAbsent(world.dimension(), k -> new HashMap<>());
        return worldMap.containsKey(pos.asLong());
    }

    public static int getBlockHP(Level world, BlockPos pos){
        HashMap<Long, Integer> worldMap = storage.computeIfAbsent(world.dimension(), k -> new HashMap<>());
        return worldMap.get(pos.asLong());
    }

    public static int getDefaultResistance(Level world, BlockPos pos){
        BlockState state = world.getBlockState(pos);
        if(state.getBlock() instanceof IBulletBreakable){
            return ((IBulletBreakable)state.getBlock()).getDefaultHP(state);
        }
        double resistance = world.getBlockState(pos).getBlock().getExplosionResistance();
        return (int) (resistance*100d);
    }

    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event){
        if(!(event.getLevel() instanceof ServerLevel)) return;
        ServerLevel world = (ServerLevel) event.getLevel();
        removeBlock(world, event.getPos());
    }

    @SubscribeEvent
    public static void saveLevel(final LevelEvent.Save event) {
        if(!(event.getLevel() instanceof ServerLevel)) return;
        ServerLevel world = (ServerLevel) event.getLevel();

        File worldFolder = ((IMinecraftServer)ServerLifecycleHooks.getCurrentServer()).getStorageSource().getDimensionPath(world.dimension()).toFile();
        HashMap<Long,Integer> worldMap = storage.computeIfAbsent(world.dimension(), k -> new HashMap<>());
        try(ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(new File(worldFolder,"tacExplosionData.dat").toPath())))
        {
            oos.writeObject(worldMap);
        }
        catch(Exception ex){
            System.out.println("Can't write tac explosion data: " + ex.getMessage());
        }
    }

    @SubscribeEvent
    public static void loadLevel(final LevelEvent.Load event) {
        if(!(event.getLevel() instanceof ServerLevel)) return;
        ServerLevel world = (ServerLevel) event.getLevel();
        File worldFolder = ((IMinecraftServer)ServerLifecycleHooks.getCurrentServer()).getStorageSource().getDimensionPath(world.dimension()).toFile();
        try(ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(new File(worldFolder,"tacExplosionData.dat").toPath())))
        {
            storage.put(world.dimension(), (HashMap<Long,Integer>)ois.readObject());
        }catch(Exception ex){
            System.out.println("Can't read tac explosion data: " + ex.getMessage());
        }
    }
}