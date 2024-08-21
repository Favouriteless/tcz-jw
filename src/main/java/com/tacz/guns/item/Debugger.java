package com.tacz.guns.item;

import com.tacz.guns.blocks.abstracts.StructureBlock;
import com.tacz.guns.world.DamageBlockSaveData;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public class Debugger extends Item {
    public Debugger(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext useOnContext) {
        Level level = useOnContext.getLevel();
        if(level.isClientSide){
            return InteractionResult.PASS;
        }

        DamageBlockSaveData damageBlockSaveData = DamageBlockSaveData.get(level);
        BlockPos pos = useOnContext.getClickedPos();
        Block block = level.getBlockState(pos).getBlock();
        Player player = useOnContext.getPlayer();

        // Si el bloque es un StructureBlock, obtener la posición del Master
        if(block instanceof StructureBlock structureBlock){
            pos = structureBlock.getMasterPos(level, pos, level.getBlockState(pos));
        }

        // Obtener la vida máxima y actual del bloque en la posición (del Master)
        int maxHp = damageBlockSaveData.getDefaultResistance(level, pos);
        int currentHp = damageBlockSaveData.hasBlock(pos) ? damageBlockSaveData.getBlockHP(pos) : maxHp;

        // Mostrar la información al jugador
        player.displayClientMessage(Component.literal(block + " " + currentHp + "/" + maxHp), false);

        return super.useOn(useOnContext);
    }
}
