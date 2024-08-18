package com.tacz.guns.data;

import com.tacz.guns.data.client.*;
import com.tacz.guns.data.loot.ModBlockLootProvider;
import com.tacz.guns.GunMod;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = GunMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    public DataGenerators(){

    }

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event){
        DataGenerator gen = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        PackOutput packOutput = gen.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        gen.addProvider(event.includeServer(), new ModBlockStateProvider(packOutput, existingFileHelper));
        gen.addProvider(event.includeServer(), new ModItemModelProvider(packOutput, existingFileHelper));
        gen.addProvider(event.includeServer(), new ModTagProvider(packOutput, lookupProvider, existingFileHelper));
        gen.addProvider(event.includeServer(), new ModRecipeProvider(packOutput));
        gen.addProvider(event.includeServer(), ModLootTableProvider.create(packOutput));
    }
}
