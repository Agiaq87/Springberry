package it.giaquinto.springberry.model.specific.runtime;

import it.giaquinto.springberry.model.time.OrderMagnitudeTime;
import it.giaquinto.springberry.model.time.TimeUnit;
import it.giaquinto.springberry.utils.time.TimeConverter;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.Map;

public final class RuntimeProperties {

    //private final RuntimeMXBean source;

    private final TimeUnit startTime;
    private final String timeZone;
    private final TimeUnit upTime;


    public RuntimeProperties() {
        var source = ManagementFactory.getRuntimeMXBean();

        startTime = TimeConverter.getInstance().toReadableUnit(source.getStartTime(), OrderMagnitudeTime.MILLI);
        timeZone = System.getProperty("user.timezone");
        upTime = TimeConverter.getInstance().toReadableUnit(source.getStartTime(), OrderMagnitudeTime.MILLI);
    }

    public TimeUnit getStartTime() {
        return startTime;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public TimeUnit getUpTime() {
        return upTime;
    }


    @Override
    public String toString() {
        return "RuntimeProperties{" +
                "startTime=" + startTime +
                ", timeZone='" + timeZone + '\'' +
                ", upTime=" + upTime +
                '}';
    }
}
