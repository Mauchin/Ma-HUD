package net.mauchin.ma_hud.screens;

import net.mauchin.ma_hud.components.AbstractHUDComponent;
import net.mauchin.ma_hud.grids.GridLocation;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ContextMenuComponent {
    String text;
    BiConsumer<GridLocation, AbstractHUDComponent> consumer;
    public ContextMenuComponent(String text, BiConsumer<GridLocation, AbstractHUDComponent> consumer){
        this.text = text;
        this.consumer = consumer;
    }
    public void run(GridLocation gridLocation,AbstractHUDComponent component){
        consumer.accept(gridLocation,component);
    }
}
