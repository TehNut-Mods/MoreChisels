package tehnut.morechisels.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tehnut.morechisels.ModInformation;

import static tehnut.morechisels.ConfigHandler.enableLogging;

public class LogHelper {

    private static Logger logger = LogManager.getLogger(ModInformation.NAME);

    public static void checkLogger() {
        if (enableLogging)
            logger.info("Logging is go!");
        else
            logger.info("Logging disabled. Enable if you wish to submit a log.");
    }

    public static void info(Object info) {
        if (enableLogging)
            logger.info(info);
    }

    public static void error(Object error) {
        if (enableLogging)
            logger.error(error);
    }

    public static void debug(Object debug) {
        if (enableLogging)
            logger.debug(debug);
    }
}
