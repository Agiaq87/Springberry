package it.giaquinto.springberry.raspberry.controller

import com.pi4j.context.Context
import com.pi4j.io.gpio.digital.DigitalOutput
import it.giaquinto.springberry.raspberry.makeDigitalOutput
import it.giaquinto.springberry.raspberry.model.pin.RaspBerryPin
import it.giaquinto.springberry.raspberry.model.pin.configuration.BlinkConfiguration
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

class RaspberryLedStatusInformer(pi4jContext: Context, red: RaspBerryPin, green: RaspBerryPin, blue: RaspBerryPin): RaspberryLedInformer {

    override val coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.IO)

    // BLUE
    // Default pin is 15 - BCM 22
    private val blueLed: DigitalOutput = pi4jContext.makeDigitalOutput(blue)
    private var blueJob: Job? = null

    // RED
    // Default pin is 37 - BCM 26
    private val redLed: DigitalOutput = pi4jContext.makeDigitalOutput(red)
    private var redJob: Job? = null


    // GREEN
    // Default pin is 13 - BCM 27
    private val greenLed: DigitalOutput = pi4jContext.makeDigitalOutput(green)
    private var greenJob: Job? = null

    // Green led for springberry start
    // Combine with red for warning
    // Combine with blue for turquoise

    fun onStart() {
        greenJob = blink(greenLed, greenJob, BlinkConfiguration.Normal, true)
    }


    fun onWarning() =
        combineBlink(
            listOf(greenLed, redLed),
            listOf(greenJob, redJob),
            BlinkConfiguration.Warning,
            true
        ).also {
            greenJob = it[0].second
            redJob = it[1].second
        }

    fun onError() =
        combineBlink(
            listOf(blueLed, redLed),
            listOf(blueJob, redJob),
            BlinkConfiguration.Warning,
            true
        ).also {
            blueJob = it[0].second
            redJob = it[1].second
        }
}