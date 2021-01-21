package ga.matthewtgm.lib.util;

import ga.matthewtgm.lib.TGMLib;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingUtils {

    private static LoggingUtils INSTANCE;

    public static LoggingUtils getInstance() {
        if (INSTANCE == null)
            INSTANCE = new LoggingUtils();
        getInstance();
        return INSTANCE;
    }

    public Logger makeClassLogger(String name) {
        return LogManager.getLogger(TGMLib.getInstance().getModName() + " (" + name + ")");
    }

    public Logger makeClassLogger(Class clazz) {
        return LogManager.getLogger(TGMLib.getInstance().getModName() + " (" + clazz.getSimpleName() + ")");
    }

}