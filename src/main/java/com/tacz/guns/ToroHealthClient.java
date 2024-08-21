package com.tacz.guns;

import com.tacz.guns.display.Hud;
import com.tacz.guns.util.RayTrace;

public class ToroHealthClient {

    public static Hud HUD = new Hud();
    public static RayTrace RAYTRACE = new RayTrace();
    public static boolean IS_HOLDING_WEAPON = false;

    public static void init() {
        ClientEventHandler.init();
    }

}
