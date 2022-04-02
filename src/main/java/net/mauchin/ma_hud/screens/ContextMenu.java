package net.mauchin.ma_hud.screens;

import net.mauchin.ma_hud.compornents.AbstractHUDComponent;
import net.mauchin.ma_hud.grids.GridLocation;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;

import java.awt.*;

public class ContextMenu{
    public int x = 0;
    public int y = 0;
    public boolean shouldRender = false;
    public GridLocation targetGridLocation;
    public AbstractHUDComponent targetComponent;
    public void render(MatrixStack matrices){
        if (this.shouldRender) {
            DrawableHelper.fill(matrices, x, y, x + 32, y + 48, 0xB0303030);
            MinecraftClient.getInstance().textRenderer.drawWithShadow(matrices, "test", x + 2, y + 2, 0xffffff);
        }
    }
}
