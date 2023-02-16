package it.giaquinto.springberry.controller.base

import it.giaquinto.springberry.controller.SpringBerryBaseController
import it.giaquinto.springberry.model.http.HttpRequest
import it.giaquinto.springberry.model.time.ReadableTime
import it.giaquinto.springberry.utils.time.TimeConverter
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class TimeCalculatorBaseController : SpringBerryBaseController() {
    override fun ID(): String {
        return TimeCalculatorBaseController::class.java.name
    }

    override fun controllerAcceptedRequest(): Array<HttpRequest> {
        return arrayOf(
            HttpRequest.GET
        )
    }

    @GetMapping(path = ["time/current-date-time"])
    fun currentDateTime(): String {
        return TimeConverter.now()
    }

    @GetMapping(path = ["time/convert-seconds-to-minute/{seconds}"])
    fun convertSecondsToMinute(@PathVariable seconds: Long): String {
        return String.format("%d minute(s)", TimeConverter.getInstance().secondsToMinute(seconds))
    }

    @GetMapping(path = ["time/convert-seconds-to-hour/{seconds}"])
    fun convertSecondsToHour(@PathVariable seconds: Long): String {
        return String.format("%d hour(s)", TimeConverter.getInstance().secondsToHour(seconds))
    }

    @GetMapping(path = ["time/convert-seconds-to-day/{seconds}"])
    fun convertSecondsToDay(@PathVariable seconds: Long): String {
        return String.format("%d day(s)", TimeConverter.getInstance().secondsToDay(seconds))
    }

    @GetMapping(path = ["time/convert-seconds-to-readable/{seconds}"])
    fun convertSecondsToReadableTime(@PathVariable seconds: Long): ReadableTime {
        return TimeConverter.getInstance().secondsToReadable(seconds)
    }
}