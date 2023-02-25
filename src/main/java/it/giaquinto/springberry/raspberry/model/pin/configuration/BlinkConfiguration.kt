package it.giaquinto.springberry.raspberry.model.pin.configuration

import java.util.concurrent.TimeUnit

sealed class BlinkConfiguration(
    val delay: Int,
    val duration: Int
) {
    val timeUnit: TimeUnit = TimeUnit.MILLISECONDS

    object Normal : BlinkConfiguration(1000, 4000)
    object Warning : BlinkConfiguration(1000, 3000)
    object Error : BlinkConfiguration(1000, 2000)
}
