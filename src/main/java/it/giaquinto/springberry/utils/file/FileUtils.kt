package it.giaquinto.springberry.utils.file;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class FileUtils {

    public static Path makeDirectory(final String path) {
        try {
            final Path tmp  = Paths.get(path);
            if (Files.notExists(tmp, LinkOption.NOFOLLOW_LINKS)) {
                Files.createDirectory(tmp);
            }
            return tmp;
        } catch (final Exception ignored) {
            return null;
        }
    }

    /**
     * The name of file consist in date
     * @param path
     * @param datePattern
     * @return
     */
    public static PrintWriter makeFile(final String path, final String datePattern, final Date date) {
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern(datePattern);

        try {
            return new PrintWriter(
                    new FileWriter(
                            String.format(
                                    "%s/%s.log", path, simpleDateFormat.format(date)
                            ),
                            true
                    )
            );
        } catch (IOException e) {
            return null;
        }
    }

}
