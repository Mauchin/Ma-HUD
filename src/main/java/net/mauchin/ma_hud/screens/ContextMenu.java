package net.mauchin.ma_hud.screens;

import net.mauchin.ma_hud.components.AbstractHUDComponent;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;

import javax.annotation.Nullable;
import java.util.List;

public class ContextMenu{
    public int x = 0;
    public int y = 0;
    public boolean shouldRender = false;
    public AbstractHUDComponent targetComponent;
    public void render(MatrixStack matrices,double mouseX, double mouseY){
        if (this.shouldRender) {
            DrawableHelper.fill(matrices, x, y, x + targetComponent.getContextWidth()+2, y + targetComponent.getContextComponents().size()*11, 0xB0303030);
            List<ContextAction> actions = targetComponent.getContextComponents();
            if (getHoveredContextAction(mouseX, mouseY) != null){
                DrawableHelper.fill(matrices,x,  y+(int)((mouseY-y)/11)*11,x+targetComponent.getContextWidth()+2, y+(int)((mouseY-y)/11+1) *11, 0xB07fff7f);
            }
            for(int i = 0; i < actions.size(); i++){
                MinecraftClient.getInstance().textRenderer.drawWithShadow(matrices, actions.get(i).text,x+1,y+11*i+1,0xffffff);
            }
        }
    }
    @Nullable
    public ContextAction getHoveredContextAction(double mouseX, double mouseY){
        if(x <= mouseX && mouseX < x + targetComponent.getContextWidth()
        && y <= mouseY && mouseY < y + targetComponent.getContextComponents().size()*11){
            return targetComponent.getContextComponents().get((int)(mouseY-y)/11);
        }
        return null;
    }
}
