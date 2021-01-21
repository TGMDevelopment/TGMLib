package ga.matthewtgm.lib.util;

public class ReflectionUtils {

    private static ReflectionUtils INSTANCE;

    public static ReflectionUtils getInstance() {
        if (INSTANCE == null)
            INSTANCE = new ReflectionUtils();
        return INSTANCE;
    }

}