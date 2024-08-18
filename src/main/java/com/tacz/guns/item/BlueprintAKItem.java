package com.tacz.guns.item;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.resources.ResourceLocation;

public class BlueprintAKItem extends Item {

        public BlueprintAKItem() {
            super((new Item.Properties()).stacksTo(1));
        }

    @Override
    public InteractionResult onItemUseFirst(ItemStack stack, UseOnContext context) {
        if (!context.getLevel().isClientSide) {
            if (context.getPlayer() instanceof ServerPlayer serverPlayer) {
                // Otorga el advancement "customadvancements:blueprint_ak47"
                serverPlayer.getAdvancements().award(
                        serverPlayer.getServer().getAdvancements().getAdvancement(
                                new ResourceLocation("customadvancements", "blueprint_ak47")
                        ),
                        "used_blueprint_ak47"
                );

                // Opcional: Consumir el item (removerlo del inventario)
                stack.shrink(1); // Reduce el stack en 1
            }
        }
        return InteractionResult.SUCCESS;
    }
}
