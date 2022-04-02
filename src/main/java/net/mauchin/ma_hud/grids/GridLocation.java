package net.mauchin.ma_hud.grids;

import net.mauchin.ma_hud.alignments.CornerAlignment;
import net.mauchin.ma_hud.utils.RenderUtils;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.Window;
import net.minecraft.client.util.math.MatrixStack;

import java.awt.*;

public class GridLocation {
    int x;
    int y;
    public GridLocation(int x,int y){
        this.x = x;
        this.y = y;
    }
    public CornerAlignment getCorner(){
        if (this.x >= 0 && this.y >= 0){
            return CornerAlignment.TOP_LEFT;
        }
        else if (this.x >= 0){
            return CornerAlignment.BOTTOM_LEFT;
        }
        else if (this.y >= 0){
            return CornerAlignment.TOP_RIGHT;
        }
        else{
            return CornerAlignment.BOTTOM_RIGHT;
        }
    }
    public int getRenderX(){
        Window window = MinecraftClient.getInstance().getWindow();
        return this.x * 16 % window.getScaledWidth();
    }
    public int getRenderY(){
        Window window = MinecraftClient.getInstance().getWindow();
        return this.y * 16 % window.getScaledHeight();
    }
    public void renderBoxOutline(MatrixStack matrices,int sizeX, int sizeY, Color color){
        RenderUtils.renderBoxOutline(matrices,getRenderX(),getRenderY(),getRenderX()+sizeX*16,getRenderY()+sizeY*16, color,4);
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}
