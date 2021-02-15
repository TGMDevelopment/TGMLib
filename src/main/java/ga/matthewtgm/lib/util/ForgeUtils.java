package ga.matthewtgm.lib.util;

import net.minecraftforge.common.MinecraftForge;

public class ForgeUtils {

    private static ForgeUtils INSTANCE;

    public static ForgeUtils getInstance() {
        if (INSTANCE == null)
            INSTANCE = new ForgeUtils();
        return INSTANCE;
    }

    public void registerEventListeners(Object... eventListenerClasses) {
        for (Object eventListenerClass : eventListenerClasses) {
            MinecraftForge.EVENT_BUS.register(eventListenerClass);
        }
    }

}