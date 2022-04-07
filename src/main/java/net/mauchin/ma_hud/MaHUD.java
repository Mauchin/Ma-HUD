package net.mauchin.ma_hud;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.mauchin.ma_hud.components.ItemCountComponent;
import net.mauchin.ma_hud.grids.Grid;
import net.mauchin.ma_hud.screens.MaHUDSettingsScreen;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.item.Items;
import net.minecraft.text.TranslatableText;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MaHUD implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("ma_hud");
	public static Grid grid = new Grid();
	public static int time = 0;

	@Override
	public void onInitialize() {
		grid.addComponent(new ItemCountComponent(0,0,Items.DIAMOND));
		grid.addComponent(new ItemCountComponent(0,1,Items.GOLD_INGOT));
		KeyBinding settingsKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
				"ma_hud.key.settings", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_G,
				"ma_hud.category"));
		KeyBinding timerKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
				"ma_hud.key.timer", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_H,
				"ma_hud.category"));
		HudRenderCallback.EVENT.register((matrices,d)->{
			grid.forEach(component -> {
				component.render(matrices);
			});
		});
		ClientTickEvents.START_CLIENT_TICK.register(client -> {
			while (settingsKey.wasPressed()){
				client.setScreenAndRender(new MaHUDSettingsScreen(new TranslatableText("ma_hud.title")));
			}
			while (timerKey.wasPressed()){
				if (time == 0){
					time = 1;
				}
				else{
					time = 0;
				}
			}
			if (time > 0){
				time++;
			}
		});
		LOGGER.info("Ma-HUD Loaded!");
	}

}
