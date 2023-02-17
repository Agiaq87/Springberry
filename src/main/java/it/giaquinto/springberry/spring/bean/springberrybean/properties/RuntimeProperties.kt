package it.giaquinto.springberry.spring.bean.springberrybean.properties

import it.giaquinto.springberry.model.time.OrderMagnitudeTime
import it.giaquinto.springberry.model.time.TimeUnit
import it.giaquinto.springberry.utils.time.TimeConverter
import java.lang.management.ManagementFactory

class RuntimeProperties {

    val startTime: TimeUnit
    val timeZone: String
        get() = System.getProperty("user.timezone")
    val upTime: TimeUnit

    init {
        ManagementFactory.getRuntimeMXBean().also {
            startTime = TimeConverter.toReadableUnit(it.startTime, OrderMagnitudeTime.MILLI)
            upTime = TimeConverter.toReadableUnit(it.startTime, OrderMagnitudeTime.MILLI)
        }
    }
}