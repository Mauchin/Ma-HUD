package net.mauchin.ma_hud.screens;

import net.mauchin.ma_hud.components.AbstractHUDComponent;
import net.mauchin.ma_hud.grids.GridLocation;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.sound.SoundEvents;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ContextAction {
    public String text;
    Consumer<AbstractHUDComponent> consumer;
    public ContextAction(String text, Consumer<AbstractHUDComponent> consumer){
        this.text = text;
        this.consumer = consumer;
    }
    public void run(AbstractHUDComponent component){
        consumer.accept(component);
        MinecraftClient.getInstance().getSoundManager().play(PositionedSoundInstance.master(SoundEvents.UI_BUTTON_CLICK,1.0f));
    }
}
