package com.tacz.guns.display;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;

public class FloatingHealthLabelRenderer {

    private static final ResourceLocation FONT_TEXTURE = new ResourceLocation("minecraft", "textures/font/ascii.png");
    private static final int LABEL_WIDTH = 50; // Ajusta el ancho de la etiqueta
    private static final int LABEL_HEIGHT = 10; // Ajusta la altura de la etiqueta
    private static final int LABEL_MARGIN = 2; // Margen alrededor del texto

    public static void renderHealthLabel(GuiGraphics guiGraphics, int x, int y, int health) {
        Minecraft mc = Minecraft.getInstance();
        String healthText = "Health: " + health;

        // Configura el shader y la textura
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, FONT_TEXTURE);

        // Calcula el tamaño del texto
        int textWidth = mc.font.width(healthText);
        int textHeight = mc.font.lineHeight;

        // Configura el color del texto y dibuja la etiqueta
        guiGraphics.drawString(mc.font, healthText, x - textWidth / 2, y - textHeight / 2, 0xFFFFFF, true);

        // Opcional: dibuja un fondo detrás del texto para mejorar la legibilidad
        drawBackground(guiGraphics, x - textWidth / 2 - LABEL_MARGIN, y - textHeight / 2 - LABEL_MARGIN, textWidth + 2 * LABEL_MARGIN, textHeight + 2 * LABEL_MARGIN);
    }

    private static void drawBackground(GuiGraphics guiGraphics, int x, int y, int width, int height) {
        // Dibuja un rectángulo sólido para el fondo de la etiqueta
        RenderSystem.setShaderColor(0.0F, 0.0F, 0.0F, 0.75F); // Color negro con algo de transparencia
        guiGraphics.fill(x, y, x + width, y + height, 0xFF000000); // Fondo negro con opacidad
    }
}

