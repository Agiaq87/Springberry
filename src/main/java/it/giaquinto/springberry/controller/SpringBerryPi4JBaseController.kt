package it.giaquinto.springberry.controller

import it.giaquinto.springberry.component.Pi4JComponent
import org.springframework.beans.factory.annotation.Autowired

abstract class SpringBerryPi4JBaseController : SpringBerryBaseController() {
    @set:Autowired
    lateinit var pi4j: Pi4JComponent
}