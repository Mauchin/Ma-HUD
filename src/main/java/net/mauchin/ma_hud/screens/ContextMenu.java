package net.mauchin.ma_hud.screens;

import net.mauchin.ma_hud.components.AbstractHUDComponent;
import net.mauchin.ma_hud.grids.GridLocation;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;

import java.util.List;

public class ContextMenu{
    public int x = 0;
    public int y = 0;
    public boolean shouldRender = false;
    public GridLocation targetGridLocation;
    public AbstractHUDComponent targetComponent;
    public void render(MatrixStack matrices,double mouseX, double mouseY){
        if (this.shouldRender) {
            DrawableHelper.fill(matrices, x, y, x + 32, y + targetComponent.getContextComponents().size()*11, 0xB0303030);
            List<ContextMenuComponent> components = targetComponent.getContextComponents();
            for(int i = 0; i < components.size(); i++){
                MinecraftClient.getInstance().textRenderer.drawWithShadow(matrices,components.get(i).text,x+1,y+11*i+1,0xffffff);
            }
        }
    }
}
