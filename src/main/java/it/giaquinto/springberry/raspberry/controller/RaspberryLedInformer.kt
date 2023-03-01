package it.giaquinto.springberry.raspberry.controller

import com.pi4j.io.gpio.digital.DigitalOutput
import it.giaquinto.springberry.raspberry.cancelIfActive
import it.giaquinto.springberry.raspberry.loop
import it.giaquinto.springberry.raspberry.model.pin.configuration.BlinkConfiguration
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

interface RaspberryLedInformer {
    val coroutineScope: CoroutineScope

    suspend fun blink(
        led: DigitalOutput,
        blinkConfiguration: BlinkConfiguration
    ): Job =
        coroutineScope.launch {
            led.on()
            delay(blinkConfiguration.delay)
            led.off()
            delay(blinkConfiguration.duration)
        }

    suspend fun combineBlink(
        ledsList: List<DigitalOutput>,
        blinkConfiguration: BlinkConfiguration
    ): List<Pair<DigitalOutput, Job>> =
        mutableListOf<Pair<DigitalOutput, Job>>().apply {
            ledsList.forEach {
                add(
                    Pair(
                        first = it,
                        second = coroutineScope.launch {
                            it.on()
                            delay(blinkConfiguration.delay)
                            it.off()
                            delay(blinkConfiguration.duration)
                        }
                    )
                )
            }
        }
}