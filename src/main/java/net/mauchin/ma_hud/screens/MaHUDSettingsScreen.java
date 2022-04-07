package net.mauchin.ma_hud.screens;

import net.mauchin.ma_hud.MaHUD;
import net.mauchin.ma_hud.grids.GridLocation;
import net.mauchin.ma_hud.utils.RenderUtils;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.Window;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

import java.awt.*;
import java.util.concurrent.atomic.AtomicReference;

public class MaHUDSettingsScreen extends Screen {
    public ContextMenu contextMenu = new ContextMenu();
    public MaHUDSettingsScreen(Text title) {
        super(title);
    }
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta){
        this.renderGrid(matrices);
        GridLocation hoveredLocation = this.getHoveredGridLocation(mouseX,mouseY);
        MaHUD.grid.forEach(component -> {
            if (component.gridLocation == hoveredLocation){
                component.gridLocation.renderBoxOutline(matrices,component.getWidth(),component.getHeight(),Color.green);
            }
            else{component.gridLocation.renderBoxOutline(matrices,component.getWidth(),component.getHeight(),Color.white);
            }
        });
        contextMenu.render(matrices,mouseX,mouseY);
    }
    public void renderGrid(MatrixStack matrices){
        Window window = MinecraftClient.getInstance().getWindow();
        int screenWidth = window.getScaledWidth();
        int screenHeight = window.getScaledHeight();
        Color gray =  new Color(128,128,128,128);
        for (int i = 0; i < screenHeight; i+=16){
            RenderUtils.renderLine(matrices,0,i,screenWidth,i, gray,2);
        }
        for (int j = 0; j < screenWidth; j+=16){
            RenderUtils.renderLine(matrices,j,0,j,screenHeight, gray, 2);
        }
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (button == 1){
            GridLocation loc = this.getHoveredGridLocation(mouseX,mouseY);
            if (loc == null){return super.mouseClicked(mouseX, mouseY, button);}
            contextMenu.shouldRender = !contextMenu.shouldRender;
            contextMenu.x = (int)mouseX;
            contextMenu.y = (int)mouseY;
            contextMenu.targetComponent = MaHUD.grid.getComponent(loc);
        }
        else if (button == 0 && contextMenu.shouldRender){
            ContextAction action = this.contextMenu.getHoveredContextAction(mouseX,mouseY);
            if (action != null) {
                action.run(contextMenu.targetComponent);
            }
            else{contextMenu.shouldRender = false;}
        }
        else if (contextMenu.shouldRender){
            contextMenu.shouldRender = false;
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    public GridLocation getHoveredGridLocation(double mouseX, double mouseY){
        //idk what this is but my IDE says it wont work otherwise so yeah
        AtomicReference<GridLocation> gridLocationToReturn = new AtomicReference<>();
        MaHUD.grid.forEach( component -> {
            if (component.gridLocation.getRenderX() <= mouseX && mouseX < component.gridLocation.getRenderX()+component.getRenderWidth()
            && component.gridLocation.getRenderY() <= mouseY && mouseY < component.gridLocation.getRenderY()+component.getRenderHeight()){
            gridLocationToReturn.set(component.gridLocation);
            }
        });
        return gridLocationToReturn.get();
    }



}
