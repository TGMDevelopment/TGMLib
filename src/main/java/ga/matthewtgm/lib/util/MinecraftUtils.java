package ga.matthewtgm.lib.util;

public class MinecraftUtils {

    private static MinecraftUtils INSTANCE;
    public static MinecraftUtils getInstance() {
        if (INSTANCE == null)
            INSTANCE = new MinecraftUtils();
        return INSTANCE;
    }

}