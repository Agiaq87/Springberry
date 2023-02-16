package it.giaquinto.springberry.model.specific.runtime

import it.giaquinto.springberry.model.time.OrderMagnitudeTime
import it.giaquinto.springberry.model.time.TimeUnit
import it.giaquinto.springberry.utils.time.TimeConverter
import java.lang.management.ManagementFactory

class RuntimeProperties {
    //private final RuntimeMXBean source;
    val startTime: TimeUnit
    val timeZone: String
    val upTime: TimeUnit

    init {
        val source = ManagementFactory.getRuntimeMXBean()
        startTime = TimeConverter.getInstance().toReadableUnit(source.startTime, OrderMagnitudeTime.MILLI)
        timeZone = System.getProperty("user.timezone")
        upTime = TimeConverter.getInstance().toReadableUnit(source.startTime, OrderMagnitudeTime.MILLI)
    }

    override fun toString(): String {
        return "RuntimeProperties{" +
                "startTime=" + startTime +
                ", timeZone='" + timeZone + '\'' +
                ", upTime=" + upTime +
                '}'
    }
}