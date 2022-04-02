package net.mauchin.ma_hud.utils;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.render.*;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Matrix3f;
import net.minecraft.util.math.Matrix4f;

import java.awt.*;

public class RenderUtils {
    public static void renderLine(MatrixStack matrices, int startX, int startY, int endX, int endY, Color color, int lineWidth){
        int red = color.getRed();
        int blue = color.getBlue();
        int green = color.getGreen();
        int alpha = color.getAlpha();
        RenderSystem.enableBlend();
        Matrix4f matrix4f = matrices.peek().getPositionMatrix();
        Matrix3f matrix3f = matrices.peek().getNormalMatrix();
        RenderSystem.setShader(GameRenderer::getRenderTypeLinesShader);
        Tessellator tessellator = RenderSystem.renderThreadTesselator();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        RenderSystem.lineWidth((float) lineWidth);
        bufferBuilder.begin(VertexFormat.DrawMode.LINES, VertexFormats.LINES);
        bufferBuilder.vertex(matrix4f, (float) startX, (float) startY, -90.0f).color(red, green, blue, alpha).normal(matrix3f, 1.0f, 1.0f, 0.0f).next();
        bufferBuilder.vertex(matrix4f, (float)endX, (float)endY, -90.0f).color(red, green, blue, alpha).normal(matrix3f, 1.0f, 1.0f, 0.0f).next();
        tessellator.draw();
        RenderSystem.lineWidth(1.0F);
    }
    public static void renderBoxOutline(MatrixStack matrices, int startX, int startY, int endX, int endY, Color color, int lineWidth){
        renderLine(matrices,startX,startY,startX,endY,color,lineWidth);
        renderLine(matrices,startX,startY,endX,startY,color,lineWidth);
        renderLine(matrices,endX,startY,endX,endY,color,lineWidth);
        renderLine(matrices,startX,endY,endX,endY,color,lineWidth);
    }
}
