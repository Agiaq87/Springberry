package it.giaquinto.springberry.raspberry.controller

import com.pi4j.io.gpio.digital.DigitalOutput
import it.giaquinto.springberry.raspberry.cancelIfActive
import it.giaquinto.springberry.raspberry.loop
import it.giaquinto.springberry.raspberry.model.pin.configuration.BlinkConfiguration
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

interface RaspberryLedInformer {
    val coroutineScope: CoroutineScope

    fun blink(
        led: DigitalOutput,
        job: Job?,
        blinkConfiguration: BlinkConfiguration,
        repeat: Boolean = false
    ): Job {
        job?.cancelIfActive()

        return coroutineScope.launch {
            if (repeat) {
                loop {
                    _blink(led, blinkConfiguration)
                }
            } else {
                _blink(led, blinkConfiguration)
            }
        }
    }

    fun combineBlink(
        ledsList: List<DigitalOutput>,
        jobsList: List<Job?>,
        blinkConfiguration: BlinkConfiguration,
        repeat: Boolean
    ): List<Pair<DigitalOutput, Job>> {
        jobsList.forEach { it?.cancelIfActive() }

        return mutableListOf<Pair<DigitalOutput, Job>>().apply {
            ledsList.forEach {
                add(
                    Pair(
                        first = it,
                        second = coroutineScope.launch {
                            if (repeat) {
                                loop {
                                    _blink(it, blinkConfiguration)
                                }
                            } else {
                                _blink(it, blinkConfiguration)
                            }
                        }
                    )
                )
            }
        }
    }

    private fun _blink(led: DigitalOutput, blinkConfiguration: BlinkConfiguration) {
        led.on()
        Thread.sleep(blinkConfiguration.delay)
        led.off()
        Thread.sleep(blinkConfiguration.duration)
    }
}