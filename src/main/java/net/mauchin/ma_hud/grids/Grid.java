package net.mauchin.ma_hud.grids;

import net.mauchin.ma_hud.compornents.AbstractHUDComponent;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Grid {
    Map<GridLocation, AbstractHUDComponent> componentMap;
    public Grid(){
        componentMap = new HashMap<>();
    }

    public void forEach(BiConsumer<GridLocation, AbstractHUDComponent> action){
        componentMap.forEach(action);
    }

    public AbstractHUDComponent getComponent(int x, int y){
        return componentMap.get(new GridLocation(x,y));
    }
    public AbstractHUDComponent getComponent(GridLocation gridLocation){return componentMap.get(gridLocation);}
    public boolean addComponent(int x, int y, AbstractHUDComponent component){
        if (!componentMap.containsKey(new GridLocation(x,y))){
            componentMap.put(new GridLocation(x,y),component);
            return true;
        }
        return false;
    }
}

