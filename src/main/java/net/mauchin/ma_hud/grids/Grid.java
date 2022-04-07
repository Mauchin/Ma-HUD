package net.mauchin.ma_hud.grids;

import net.mauchin.ma_hud.components.AbstractHUDComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Grid {
    List<AbstractHUDComponent> componentList = new ArrayList<>();


    public void forEach(Consumer<AbstractHUDComponent> action){
        componentList.forEach(action);
    }

    public AbstractHUDComponent getComponent(int x, int y){
        for(AbstractHUDComponent component: componentList){
            if(component.gridLocation.x == x &&component.gridLocation.y == y){
                return component;
            }
        }
        return null;
    }
    public AbstractHUDComponent getComponent(GridLocation gridLocation){
        for(AbstractHUDComponent component: componentList){
            if(component.gridLocation == gridLocation){
                return component;
            }
        }
        return null;
    }
    public boolean addComponent(AbstractHUDComponent component){
        for(AbstractHUDComponent component1: componentList){
            if(component.gridLocation.x == component1.gridLocation.x && component.gridLocation.y == component1.gridLocation.y){
                return false;
            }
        }
        componentList.add(component);
        return true;

    }
}

