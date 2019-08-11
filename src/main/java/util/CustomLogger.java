package util;

import org.apache.log4j.Logger;
import org.testng.Reporter;


public class CustomLogger {

    private CustomLogger() {
        throw new IllegalStateException("Utility class");
    }

    private static Logger log = Logger.getLogger(CustomLogger.class.getName());


    public static void info (final String message) {
        log.info(message);
        Reporter.log("<br> [Log] <b>" + message + "</b>");
    }

    public static void warn (final String message) {
        log.warn(message);
        Reporter.log("<br> [Log] <b>" + message + "</b>");
    }

    public static void error (final String message) {
        log.error(message);
        Reporter.log("<br> [Log] <b>" + message + "</b>");
    }

    public static void fatal (final String message) {
        log.fatal(message);
        Reporter.log("<br> [Log] <b>" + message + "</b>");
    }

    public static void debug (final String message) {
        log.debug(message);
        Reporter.log("<br> [Log] <b>" + message + "</b>");
    }

}
