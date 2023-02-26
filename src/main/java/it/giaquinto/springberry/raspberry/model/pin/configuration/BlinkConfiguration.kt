package it.giaquinto.springberry.raspberry.model.pin.configuration

import java.util.concurrent.TimeUnit

sealed class BlinkConfiguration(
    val delay: Long,
    val duration: Long
) {
    val timeUnit: TimeUnit = TimeUnit.MILLISECONDS

    object Normal : BlinkConfiguration(100L, 4500L)
    object Warning : BlinkConfiguration(100L, 3000L)
    object Error : BlinkConfiguration(100L, 1500L)

    object Request: BlinkConfiguration(50L, 5L)

    object Response: BlinkConfiguration(50L, 5L)
    object HandlerException : BlinkConfiguration(50L, 50L)

}
