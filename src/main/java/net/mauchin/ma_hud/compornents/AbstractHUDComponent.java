package net.mauchin.ma_hud.compornents;

import net.mauchin.ma_hud.alignments.Alignment;
import net.mauchin.ma_hud.grids.GridLocation;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.Window;
import net.minecraft.client.util.math.MatrixStack;

public abstract class AbstractHUDComponent {

    //TODO Make Grid (16x16) for each corner
    public abstract int getHeight();
    public abstract int getWidth();
    public abstract void render(MatrixStack matrices,int x,int y);
    public abstract void tick();
    public void render(MatrixStack matrices, GridLocation gridLocation){
        this.render(matrices,gridLocation.getRenderX(),gridLocation.getRenderY());
    }
    public int getRenderWidth(){
        return this.getWidth()*16;
    }
    public int getRenderHeight(){
        return this.getHeight()*16;
    }
}
