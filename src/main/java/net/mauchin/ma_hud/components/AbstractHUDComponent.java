package net.mauchin.ma_hud.components;

import net.mauchin.ma_hud.grids.GridLocation;
import net.mauchin.ma_hud.screens.ContextAction;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;

import java.util.List;

public abstract class AbstractHUDComponent {

    public GridLocation gridLocation;
    public AbstractHUDComponent(GridLocation gridLocation){
        this.gridLocation = gridLocation;
    }
    public AbstractHUDComponent(int x, int y){
        this.gridLocation = new GridLocation(x,y);
    }

    public abstract int getHeight();
    public abstract int getWidth();
    public abstract void render(MatrixStack matrices);
    public abstract void tick();
    public abstract List<ContextAction> getContextComponents();

    public int getRenderWidth(){
        return this.getWidth()*16;
    }
    public int getRenderHeight(){
        return this.getHeight()*16;
    }
    public int getContextWidth(){
        int max = 0;
        for (ContextAction action: getContextComponents()){
            max = Math.max(MinecraftClient.getInstance().textRenderer.getWidth(action.text),max);
        }
        return max;
    }

}
