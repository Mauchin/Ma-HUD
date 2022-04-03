package net.mauchin.ma_hud.screens;

import net.mauchin.ma_hud.components.AbstractHUDComponent;
import net.mauchin.ma_hud.grids.GridLocation;
import net.mauchin.ma_hud.utils.RandomUtils;

import java.lang.ref.Reference;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class BooleanContextMenuComponent extends ContextMenuComponent{
    public BooleanContextMenuComponent(String text, AtomicReference<Boolean> bool) {
        super(RandomUtils.getNextEnableActionText(Boolean.TRUE.equals(bool.get()))+" "+text,(gridLocation, component) -> {
            bool.set(!bool.get());
        });
    }

    @Override
    public void run(GridLocation gridLocation, AbstractHUDComponent component) {

    }
}
