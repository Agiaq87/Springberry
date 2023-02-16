package it.giaquinto.springberry.controller.pi4j

import it.giaquinto.springberry.component.SpringBerryLoggerComponent.Companion.instance
import it.giaquinto.springberry.controller.SpringBerryPi4JBaseController
import it.giaquinto.springberry.model.http.HttpRequest
import it.giaquinto.springberry.model.log.LogMessageFactory
import it.giaquinto.springberry.model.raspberry.component.RaspBerryLedComponent
import it.giaquinto.springberry.model.raspberry.pin.RaspberryEnumPin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class LedBaseController : SpringBerryPi4JBaseController() {
    override fun ID(): String {
        return LedBaseController::class.java.name
    }

    override fun controllerAcceptedRequest(): Array<HttpRequest> {
        return arrayOf(
            HttpRequest.GET
        )
    }

    @GetMapping(path = ["led/{pin}"])
    fun blinkLed(@PathVariable pin: Int): String {
        return if (RaspberryEnumPin.haveRelativePin(pin)) {
            pi4j.getRaspBerryLedComponent(RaspberryEnumPin.fromInt(pin)).thenAccept { led: RaspBerryLedComponent ->
                led.on()
                instance().writeLog(
                    LogMessageFactory.Pin.d(String.format("Address pin: %d", led.address.pin))
                )
            }
            Integer.toString(pin)
        } else {
            "Invalid pin inserted"
        }
    }
}