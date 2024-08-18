package com.tacz.guns.item;

import com.tacz.guns.world.ExplodedBlocksStorage;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class HPCheckerItem extends Item {
    public HPCheckerItem() {
        super((new Item.Properties()).stacksTo(1));
    }

    @Override
    public InteractionResult onItemUseFirst(ItemStack stack, UseOnContext context) {
        BlockPos pos = context.getClickedPos();
        Level world = context.getLevel();
        int maxHP = ExplodedBlocksStorage.getDefaultResistance(world, pos);
        int curHP = ExplodedBlocksStorage.hasBlock(world, pos)? ExplodedBlocksStorage.getBlockHP(world, pos): maxHP;
        String msg = curHP+" / "+maxHP + " HP";
        context.getPlayer().sendSystemMessage(Component.literal(msg));
        return super.onItemUseFirst(stack, context);
    }
}