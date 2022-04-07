package net.mauchin.ma_hud.components;

import net.mauchin.ma_hud.grids.GridLocation;
import net.mauchin.ma_hud.screens.ContextAction;
import net.minecraft.client.util.math.MatrixStack;

import java.util.List;

public class TimerComponent extends AbstractHUDComponent{
    public TimerComponent(GridLocation gridLocation) {
        super(gridLocation);
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public void render(MatrixStack matrices) {

    }

    @Override
    public void tick() {

    }

    @Override
    public List<ContextAction> getContextComponents() {
        return null;
    }
}
