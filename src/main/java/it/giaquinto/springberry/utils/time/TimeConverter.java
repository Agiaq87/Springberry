package it.giaquinto.springberry.utils.time;

import it.giaquinto.springberry.model.time.OrderMagnitudeTime;
import it.giaquinto.springberry.model.time.TimeUnit;

public final class TimeConverter {
    private static TimeConverter INSTANCE = null;

    private TimeConverter() { };

    public static TimeConverter getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TimeConverter();
        }

        return INSTANCE;
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
}
