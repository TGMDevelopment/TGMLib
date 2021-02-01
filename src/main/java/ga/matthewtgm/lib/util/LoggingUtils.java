package ga.matthewtgm.lib.util;

import ga.matthewtgm.lib.TGMLib;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Creates custom loggers.
 */
public class LoggingUtils {

    private static LoggingUtils INSTANCE;

    /**
     * @return an instance of {@link LoggingUtils}.
     */
    public static LoggingUtils getInstance() {
        if (INSTANCE == null)
            INSTANCE = new LoggingUtils();
        return INSTANCE;
    }

    /**
     * Creates a logger with the name specified. (uses the mod name set in {@code TGMLib#setModName} to create a nice prefix.)
     *
     * @param name logger name.
     * @return an instance of {@link Logger}.
     */
    public Logger createLogger(String name) {
        return LogManager.getLogger(TGMLib.getInstance().getModName() + " (" + name + ")");
    }

    /**
     * Creates a logger with the class specified. (uses the mod name set in {@code TGMLib#setModName} to create a nice prefix.)
     *
     * @param clazz logger class. (gets the class name and converts it into a string.)
     * @return an instance of {@link Logger}.
     */
    public Logger createClassLogger(Class clazz) {
        return LogManager.getLogger(TGMLib.getInstance().getModName() + " (" + clazz.getSimpleName() + ")");
    }

}