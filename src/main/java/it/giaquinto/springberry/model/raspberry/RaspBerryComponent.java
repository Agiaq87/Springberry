package it.giaquinto.springberry.model.raspberry;

import java.util.logging.Logger;

public class RaspBerryComponent {
    private final Logger logger = Logger.getLogger(getClass().getName());

    protected void logInfo(String msg) {
        logger.info(() -> msg);
    }

    protected void logError(String msg) {
        logger.severe(() -> msg);
    }

    protected void logConfig(String msg) {
        logger.config(() -> msg);
    }

    protected void logDebug(String msg) {
        logger.fine(() -> msg);
    }

    void delay(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
