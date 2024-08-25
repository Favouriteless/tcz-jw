package com.tacz.guns.events;

import com.tacz.guns.GunMod;
import com.tacz.guns.network.ServerBoundHoverOverBlockPacket;
import com.tacz.guns.client.StructureBlockHPScreen;
import com.tacz.guns.init.PacketHandler;
import com.tacz.guns.util.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = GunMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class WallHPDisplayHandler {

    static boolean shouldRenderOverlay = false;

    @SubscribeEvent
    public static void mouseMove(TickEvent.ClientTickEvent event){
        Minecraft minecraft = Minecraft.getInstance();
        HitResult hitResult = minecraft.hitResult;
        if(hitResult != null){
            shouldRenderOverlay = hitResult instanceof BlockHitResult;
            if(hitResult instanceof BlockHitResult blockHitResult){
                BlockPos blockPos = blockHitResult.getBlockPos();
                if(minecraft.getConnection() != null){
                    PacketHandler.INSTANCE.sendToServer(new ServerBoundHoverOverBlockPacket(blockPos.getX(), blockPos.getY(), blockPos.getZ()));
                }
            }
        }
    }

    @SubscribeEvent
    public static void renderOverlay(RenderGuiOverlayEvent.Post event){
        if(shouldRenderOverlay){
            GuiGraphics guiGraphics = event.getGuiGraphics();
            StructureBlockHPScreen.renderOverlay(guiGraphics);
        }
    }
}
