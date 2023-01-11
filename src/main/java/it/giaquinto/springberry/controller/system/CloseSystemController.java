package it.giaquinto.springberry.controller.system;

import it.giaquinto.springberry.controller.SpringBerrySystemController;
import it.giaquinto.springberry.model.system.SystemExit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CloseSystemController extends SpringBerrySystemController {

    @GetMapping(path = "/system/close")
    public void systemReboot() {
        System.exit(SystemExit.valueOf(SystemExit.TRIGGERED));
    }
}
