package ga.matthewtgm.lib.util;

/**
 * Adds utilities for the base game. (everything not already added in all the other utils.)
 */
public class MinecraftUtils {

    private static MinecraftUtils INSTANCE;

    /**
     * @return an instance of {@link MinecraftUtils}.
     */
    public static MinecraftUtils getInstance() {
        if (INSTANCE == null)
            INSTANCE = new MinecraftUtils();
        return INSTANCE;
    }

}