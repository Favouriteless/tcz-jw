package com.tacz.guns.util;

import com.tacz.guns.GunMod;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.item.SwordItem;
import com.tacz.guns.GunMod;
import com.tacz.guns.config.Config.Mode;

public class HoldingWeaponUpdater {
    public static void update() {
        if (Mode.NONE.equals(GunMod.CONFIG.inWorld.mode))
            return;
        Minecraft minecraft = Minecraft.getInstance();
        Player player = minecraft.player;
        if (player == null) {
            GunMod.IS_HOLDING_WEAPON = false;
            return;
        }
        GunMod.IS_HOLDING_WEAPON =
                isWeapon(player.getMainHandItem()) || isWeapon(player.getOffhandItem());
    }

    private static boolean isWeapon(ItemStack item) {
        return item.getItem() instanceof SwordItem || item.getItem() instanceof BowItem
                || item.getItem() instanceof PotionItem;
    }
}
