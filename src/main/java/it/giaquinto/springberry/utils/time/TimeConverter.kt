package it.giaquinto.springberry.utils.time;

import it.giaquinto.springberry.model.time.OrderMagnitudeTime;
import it.giaquinto.springberry.model.time.ReadableTime;
import it.giaquinto.springberry.model.time.TimeUnit;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public final class TimeConverter {
    private static TimeConverter INSTANCE = null;

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");

    private TimeConverter() { };

    public static TimeConverter getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TimeConverter();
        }

        return INSTANCE;
    }

    public DateTimeFormatter getStandardDateTimeFormatter() {
        return dateTimeFormatter;
    }

    public static String now() {
        return LocalDateTime.now().format(dateTimeFormatter);
    }

    public long toMicroSeconds(final long nanoseconds) {
        return nanoseconds/1000;
    }

    public TimeUnit toReadableUnit(final long value, final OrderMagnitudeTime orderMagnitudeTime) {
        long returnedTime = value;
        OrderMagnitudeTime returnedMagnitude = orderMagnitudeTime;
        boolean continueRedux = value > 1000;

        while (continueRedux) {
            returnedTime/=1000;
            returnedMagnitude = OrderMagnitudeTime.toNext(returnedMagnitude);

            continueRedux = returnedTime > 1000;
        }

        return new TimeUnit(value, returnedTime, returnedMagnitude);
    }

    public long secondsToMinute(final long seconds) {
        return seconds/60;
    }

    public long secondsToHour(final long seconds) {
        return seconds/3600;
    }

    public long secondsToDay(final long seconds) {
        return seconds/86400;
    }

    public ReadableTime secondsToReadable(final long seconds) {
        return new ReadableTime(seconds);
    }

    public long distanceInDaysBetween(final Date first, final Date second) {
        return java.util.concurrent.TimeUnit.DAYS.convert(
                Math.abs(first.getTime() - second.getTime()),
                java.util.concurrent.TimeUnit.MILLISECONDS
        );
    }
}
