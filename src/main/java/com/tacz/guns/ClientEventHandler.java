package com.tacz.guns;


import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.model.EntityModel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.client.event.RenderLevelStageEvent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.client.gui.overlay.VanillaGuiOverlay;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import com.tacz.guns.bars.BarStates;
import com.tacz.guns.bars.HealthBarRenderer;
import com.tacz.guns.bars.ParticleRenderer;
import com.tacz.guns.util.HoldingWeaponUpdater;
import com.tacz.guns.config.Config;

public class ClientEventHandler {

    public static void init() {
        MinecraftForge.EVENT_BUS.addListener(ClientEventHandler::playerTick);
        MinecraftForge.EVENT_BUS.addListener(ClientEventHandler::entityRender);
        MinecraftForge.EVENT_BUS.addListener(ClientEventHandler::renderParticles);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientEventHandler::registerOverlays);
    }

    private static void registerOverlays(final RegisterGuiOverlaysEvent event) {
        event.registerAbove(VanillaGuiOverlay.POTION_ICONS.id(), "torohealth_hud", ToroHealthClient.HUD::render);
    }

    private static void entityRender(
            RenderLivingEvent.Post<? extends LivingEntity, ? extends EntityModel<?>> event) {
        HealthBarRenderer.prepareRenderInWorld(event.getEntity());
    }

    private static void renderParticles(RenderLevelStageEvent event) {
        if (event.getStage() == RenderLevelStageEvent.Stage.AFTER_PARTICLES) {
            Camera camera = Minecraft.getInstance().gameRenderer.getMainCamera();
            Minecraft mc = Minecraft.getInstance();
            GuiGraphics gui = new GuiGraphics(mc, mc.renderBuffers().bufferSource());
            gui.pose().mulPoseMatrix(event.getPoseStack().last().pose());
            ParticleRenderer.renderParticles(gui, camera);
            HealthBarRenderer.renderInWorld(event.getPartialTick(), gui, camera);
        }
    }

    private static void playerTick(PlayerTickEvent event) {
        if (!event.player.isLocalPlayer()) {
            return;
        }
        ToroHealthClient.HUD.setEntity(
                ToroHealthClient.RAYTRACE.getEntityInCrosshair(0, GunMod.CONFIG.hud.distance));
        BarStates.tick();
        HoldingWeaponUpdater.update();
        ToroHealthClient.HUD.tick();
    }
}
