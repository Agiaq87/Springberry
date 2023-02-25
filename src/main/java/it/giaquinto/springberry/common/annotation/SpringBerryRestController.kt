package it.giaquinto.springberry.common.annotation

import org.springframework.core.annotation.AliasFor
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.ResponseBody

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Controller
@ResponseBody
annotation class SpringBerryRestController(@get:AliasFor(annotation = Controller::class) val value: String = "")