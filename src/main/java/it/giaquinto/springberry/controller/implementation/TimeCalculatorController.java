package it.giaquinto.springberry.controller.implementation;

import it.giaquinto.springberry.controller.SpringBerryController;
import it.giaquinto.springberry.model.http.HttpRequest;
import it.giaquinto.springberry.model.time.ReadableTime;
import it.giaquinto.springberry.utils.time.TimeConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class TimeCalculatorController extends SpringBerryController {
    @Override
    public String ID() {
        return TimeCalculatorController.class.getName();
    }

    @Override
    public HttpRequest[] controllerAcceptedRequest() {
        return new HttpRequest[] {
                HttpRequest.GET
        };
    }
    @GetMapping(path= "/current-date-time")
    public String currentDateTime() {
        return TimeConverter.now();
    }

    @GetMapping(path= "/convert-seconds-to-minute/{seconds}")
    public String convertSecondsToMinute(@PathVariable long seconds) {
        return String.format("%d minute(s)", TimeConverter.getInstance().secondsToMinute(seconds));
    }

    @GetMapping(path= "/convert-seconds-to-hour/{seconds}")
    public String convertSecondsToHour(@PathVariable long seconds) {
        return String.format("%d hour(s)", TimeConverter.getInstance().secondsToHour(seconds));
    }

    @GetMapping(path= "/convert-seconds-to-day/{seconds}")
    public String convertSecondsToDay(@PathVariable long seconds) {
        return String.format("%d day(s)", TimeConverter.getInstance().secondsToDay(seconds));
    }

    @GetMapping(path= "/convert-seconds-to-readable/{seconds}")
    public ReadableTime convertSecondsToReadableTime(@PathVariable long seconds) {
        return TimeConverter.getInstance().secondsToReadable(seconds);
    }


}
