package com.tacz.guns.client;

import com.mojang.blaze3d.platform.InputConstants;
import com.tacz.guns.GunMod;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;

public final class Keybindings {
    public static final Keybindings INSTANCE = new Keybindings();

    private Keybindings(){}

    private static final String CATEGORY = "key.categories." + GunMod.MOD_ID;

    public final KeyMapping guiKey = new KeyMapping(
            "key." + GunMod.MOD_ID + ".gui_key",
            KeyConflictContext.IN_GAME,
            InputConstants.getKey(InputConstants.KEY_G, -1),
            CATEGORY
    );
}
