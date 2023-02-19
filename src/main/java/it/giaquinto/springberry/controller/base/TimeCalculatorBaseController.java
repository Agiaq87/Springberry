package it.giaquinto.springberry.controller.base;

import it.giaquinto.springberry.controller.SpringBerryBaseController;
import it.giaquinto.springberry.spring.model.http.HttpRequest;
import it.giaquinto.springberry.spring.model.time.ReadableTime;
import it.giaquinto.springberry.spring.utils.time.TimeConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class TimeCalculatorBaseController extends SpringBerryBaseController {
    @Override
    public String ID() {
        return TimeCalculatorBaseController.class.getName();
    }

    @Override
    public HttpRequest[] controllerAcceptedRequest() {
        return new HttpRequest[] {
                HttpRequest.GET
        };
    }
    @GetMapping(path= "time/current-date-time")
    public String currentDateTime() {
        return TimeConverter.now(true);
    }

    @GetMapping(path= "time/convert-seconds-to-minute/{seconds}")
    public String convertSecondsToMinute(@PathVariable long seconds) {
        return String.format("%d minute(s)", TimeConverter.INSTANCE.secondsToMinute(seconds));
    }

    @GetMapping(path= "time/convert-seconds-to-hour/{seconds}")
    public String convertSecondsToHour(@PathVariable long seconds) {
        return String.format("%d hour(s)", TimeConverter.INSTANCE.secondsToHour(seconds));
    }

    @GetMapping(path= "time/convert-seconds-to-day/{seconds}")
    public String convertSecondsToDay(@PathVariable long seconds) {
        return String.format("%d day(s)", TimeConverter.INSTANCE.secondsToDay(seconds));
    }

    @GetMapping(path= "time/convert-seconds-to-readable/{seconds}")
    public ReadableTime convertSecondsToReadableTime(@PathVariable long seconds) {
        return TimeConverter.INSTANCE.secondsToReadable(seconds);
    }


}
