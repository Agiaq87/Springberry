package it.giaquinto.springberry.utils.time

import it.giaquinto.springberry.model.time.OrderMagnitudeTime
import it.giaquinto.springberry.model.time.ReadableTime
import it.giaquinto.springberry.model.time.TimeUnit
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.math.abs

object TimeConverter {
    fun toMicroSeconds(nanoseconds: Long): Long {
        return nanoseconds / 1000
    }

    fun toReadableUnit(value: Long, orderMagnitudeTime: OrderMagnitudeTime): TimeUnit {
        var returnedTime = value
        var returnedMagnitude = orderMagnitudeTime
        var continueRedux = value > 1000
        while (continueRedux && OrderMagnitudeTime.hasNext(returnedMagnitude)) {
            returnedTime /= 1000
            returnedMagnitude = OrderMagnitudeTime.toNext(returnedMagnitude)
            continueRedux = returnedTime > 1000
        }
        return TimeUnit(value, returnedTime, returnedMagnitude)
    }

    fun secondsToMinute(seconds: Long): Long {
        return seconds / 60
    }

    fun secondsToHour(seconds: Long): Long {
        return seconds / 3600
    }

    fun secondsToDay(seconds: Long): Long {
        return seconds / 86400
    }

    fun secondsToReadable(seconds: Long): ReadableTime {
        return ReadableTime(seconds)
    }

    fun distanceInDaysBetween(first: Date, second: Date): Long {
        return java.util.concurrent.TimeUnit.DAYS.convert(
            abs(first.time - second.time),
            java.util.concurrent.TimeUnit.MILLISECONDS
        )
    }

    @JvmStatic
    private val standardDateTimeFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy")

    @JvmStatic
    fun now(): String {
        return LocalDateTime.now().format(standardDateTimeFormatter)
    }
}