package it.giaquinto.springberry.component;

import it.giaquinto.springberry.model.log.LogMessage;
import it.giaquinto.springberry.model.log.LogMessageFactory;
import it.giaquinto.springberry.model.log.LogOut;
import it.giaquinto.springberry.utils.file.FileUtils;
import it.giaquinto.springberry.utils.time.TimeConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CompletableFuture;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class SpringBerryLoggerComponent implements AsyncUncaughtExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger("SpringBerry");
    private final SimpleDateFormat simpleDateFormat;
    private TimeConverter timeUnit;
    private PrintWriter outputFileWriter;
    private Date currentDate;
    private LogMessage lastLogMessage;


    private SpringBerryLoggerComponent() {
        simpleDateFormat = new SimpleDateFormat();
        timeUnit = TimeConverter.getInstance();
        FileUtils.makeDirectory(directory);
        currentDate = new Date();
        outputFileWriter = FileUtils.makeFile(directory, filePattern, currentDate);
        simpleDateFormat.applyPattern(logPattern);
        lastLogMessage = LogMessageFactory.direct("");
    }

    public static SpringBerryLoggerComponent instance() {
        return new SpringBerryLoggerComponent();
    }

    @Async
    public CompletableFuture<LogMessage> startLog() {
        return writeLog(LogMessageFactory.direct("SpringBerry started"));
    }

    @Async
    public CompletableFuture<LogMessage> writeLog(final LogMessage logMessage) {
        if (lastLogMessage.equals(logMessage)) {
            return CompletableFuture.completedFuture(LogMessageFactory.verbose("Already printed"));
        }

        switch (logMessage.getLogOut()) {
            case DIRECT -> logger.trace(logMessage.getMessage());
            case VERBOSE -> logger.info(logMessage.getMessage());
            case WARNING -> logger.warn(logMessage.getMessage());
            case ERROR -> logger.error(logMessage.getMessage());
        }

        if (isCurrentDateNotUpdate()) {
            initFile();
        }

        if (outputFileWriter != null) {
            outputFileWriter.write(
                    String.format("%s - [%s] - %s\n",
                            simpleDateFormat.format(
                                    logMessage.getDate()
                            ),
                            logMessage.getLogOut().getOutput(),
                            logMessage.getMessage()
                    )
            );
            outputFileWriter.flush();
            outputFileWriter.close();
        }

        lastLogMessage = logMessage;

        return CompletableFuture.completedFuture(logMessage);
    }

    @Override
    public void handleUncaughtException(Throwable ex, Method method, Object... params) {
        writeLog(
                LogMessageFactory.error(
                        String.format(
                                "Ex: %s - Method: %s - Params: %s",
                                ex.toString(),
                                method.toString(),
                                params.toString()
                        )
                )
        );
    }

    private void initFile() {
        currentDate = new Date();
        outputFileWriter = FileUtils.makeFile(directory, filePattern, currentDate);
    }

    private boolean isCurrentDateNotUpdate() {
        return timeUnit.distanceInDaysBetween(currentDate, new Date()) != 0;
    }

    private static final String logPattern = "dd-MM-yy-HH.mm.ss SSS";
    private static final String filePattern = "dd-MM-yyyy";
    private static final String directory = "log";
}
