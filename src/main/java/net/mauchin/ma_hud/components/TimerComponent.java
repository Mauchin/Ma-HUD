package net.mauchin.ma_hud.components;

import net.mauchin.ma_hud.screens.ContextMenuComponent;
import net.minecraft.client.util.math.MatrixStack;

import java.util.List;

public class TimerComponent extends AbstractHUDComponent{
    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public void render(MatrixStack matrices, int x, int y) {

    }

    @Override
    public void tick() {

    }

    @Override
    public List<ContextMenuComponent> getContextComponents() {
        return null;
    }
}
