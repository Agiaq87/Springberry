package it.giaquinto.springberry.controller.system

import it.giaquinto.springberry.controller.SpringBerrySystemController
import it.giaquinto.springberry.model.system.SystemExit
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.system.exitProcess

@RestController
class CloseSystemController : SpringBerrySystemController() {
    @GetMapping(path = ["/system/close"])
    fun systemReboot() {
        exitProcess(SystemExit.valueOf(SystemExit.TRIGGERED))
    }
}