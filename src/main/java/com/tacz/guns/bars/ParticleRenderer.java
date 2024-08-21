package com.tacz.guns.bars;

import org.lwjgl.opengl.GL11;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.math.Axis;

import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import com.tacz.guns.GunMod;
import com.tacz.guns.config.Config;

public class ParticleRenderer {

    public static void renderParticles(GuiGraphics gui, Camera camera) {
        for (BarParticle p : BarStates.PARTICLES) {
            renderParticle(gui, p, camera);
        }
    }

    private static void renderParticle(GuiGraphics gui, BarParticle particle, Camera camera) {
        double distanceSquared = camera.getPosition().distanceToSqr(particle.x, particle.y, particle.z);
        if (distanceSquared > GunMod.CONFIG.particle.distanceSquared) {
            return;
        }

        float scaleToGui = 0.025f;

        Minecraft client = Minecraft.getInstance();
        float tickDelta = client.getDeltaFrameTime();

        double x = Mth.lerp((double) tickDelta, particle.xPrev, particle.x);
        double y = Mth.lerp((double) tickDelta, particle.yPrev, particle.y);
        double z = Mth.lerp((double) tickDelta, particle.zPrev, particle.z);

        Vec3 camPos = camera.getPosition();
        double camX = camPos.x;
        double camY = camPos.y;
        double camZ = camPos.z;

        gui.pose().pushPose();
        gui.pose().translate(x - camX, y - camY, z - camZ);
        gui.pose().mulPose(Axis.YP.rotationDegrees(-camera.getYRot()));
        gui.pose().mulPose(Axis.XP.rotationDegrees(camera.getXRot()));
        gui.pose().scale(-scaleToGui, -scaleToGui, scaleToGui);

        RenderSystem.setShader(GameRenderer::getPositionColorShader);
        RenderSystem.enableDepthTest();
        RenderSystem.enableBlend();
        RenderSystem.blendFuncSeparate(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA, GL11.GL_ONE,
                GL11.GL_ZERO);

        HealthBarRenderer.drawDamageNumber(gui, particle.damage, 0, 0, 10);

        RenderSystem.disableBlend();

        gui.pose().popPose();
    }
}