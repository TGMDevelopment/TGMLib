package ga.matthewtgm.lib.util;

/**
 * Makes Java reflection easier.
 */
public class ReflectionUtils {

    private static ReflectionUtils INSTANCE;

    /**
     * @return an instance of {@link ReflectionUtils}.
     */
    public static ReflectionUtils getInstance() {
        if (INSTANCE == null)
            INSTANCE = new ReflectionUtils();
        return INSTANCE;
    }

}