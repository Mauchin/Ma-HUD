package net.mauchin.ma_hud.components;

import net.mauchin.ma_hud.grids.GridLocation;
import net.mauchin.ma_hud.screens.ContextMenuComponent;
import net.minecraft.client.util.math.MatrixStack;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractHUDComponent {

    public abstract int getHeight();
    public abstract int getWidth();
    public abstract void render(MatrixStack matrices,int x,int y);
    public abstract void tick();
    public abstract List<ContextMenuComponent> getContextComponents();

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
