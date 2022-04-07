package net.mauchin.ma_hud.utils;

public class RandomUtils {
    public static String getNextEnableActionText(boolean bool){
        if (bool){return "Disable";}
        return "Enable";
    }
}
