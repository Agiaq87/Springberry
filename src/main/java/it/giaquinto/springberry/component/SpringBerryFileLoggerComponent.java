package it.giaquinto.springberry.component;

import it.giaquinto.springberry.model.log.LogOut;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Lazy
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class SpringBerryFileLoggerComponent {
    private final BufferedWriter bufferedWriter;
    private final SimpleDateFormat simpleDateFormat;

    public SpringBerryFileLoggerComponent() {
        try (final FileWriter fileWriter = new FileWriter("SpringBerryLog.txt")) {
            this.bufferedWriter = new BufferedWriter(fileWriter);
            this.simpleDateFormat = new SimpleDateFormat();
            this.simpleDateFormat.applyPattern("dd-MM-yy-HH.mm.ss SSS");
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Async
    public void writeLog(final String msg, final LogOut logout) {
        try {
            bufferedWriter.write(
                    String.format("%s - [%s] - %s", simpleDateFormat.format(new Date()), logout.getOutput(),  msg)
            );
            bufferedWriter.close();
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Async
    public void writeDirectLog(final String msg) {
        writeLog(msg, LogOut.DIRECT);
    }

    @Async
    public void writeVerbose(final String msg) {
        writeLog(msg, LogOut.VERBOSE);
    }

    @Async
    public void writeWarning(final String msg) {
        writeLog(msg, LogOut.WARNING);
    }

    @Async
    public void writeError(final String msg) {
        writeLog(msg, LogOut.ERROR);
    }
}
