package net.mauchin.ma_hud.screens;

import net.mauchin.ma_hud.components.AbstractHUDComponent;
import net.mauchin.ma_hud.grids.GridLocation;
import net.mauchin.ma_hud.utils.RandomUtils;

import java.util.concurrent.atomic.AtomicReference;

public class BooleanContextAction extends ContextAction {
    public BooleanContextAction(String text, AtomicReference<Boolean> bool) {
        super(RandomUtils.getNextEnableActionText(Boolean.TRUE.equals(bool.get()))+" "+text,(component) -> {
            bool.set(!bool.get());
        });
    }
}
