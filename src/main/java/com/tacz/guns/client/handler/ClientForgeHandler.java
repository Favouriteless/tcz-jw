package com.tacz.guns.client.handler;

import com.tacz.guns.GunMod;
import com.tacz.guns.client.Keybindings;
import com.tacz.guns.client.RadialMenu;
import com.tacz.guns.init.ModItems;
import com.tacz.guns.item.SuperHammer;
import com.tacz.guns.util.RadialMenuItem;
import com.tacz.guns.GunMod;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = GunMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ClientForgeHandler {
    @SubscribeEvent
    public static void clientTick(TickEvent.ClientTickEvent event){
        Minecraft minecraft = Minecraft.getInstance();
        if(Keybindings.INSTANCE.guiKey.consumeClick() && minecraft.player != null){
            ItemStack itemStack = minecraft.player.getItemInHand(InteractionHand.MAIN_HAND);
            if(itemStack.getItem() instanceof SuperHammer){
                Minecraft.getInstance().setScreen(new RadialMenu(RadialMenuItem.MAIN_MENU));
//                minecraft.player.displayClientMessage(Component.literal("Key Pressed"), true);
            }
        }
    }
}
