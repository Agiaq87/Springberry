package it.giaquinto.springberry.spring.controller.about

import it.giaquinto.springberry.model.http.HttpRequest
import it.giaquinto.springberry.spring.bean.springberrybean.properties.ThreadProperties
import it.giaquinto.springberry.spring.bean.springberrybean.properties.UserProperties
import it.giaquinto.springberry.spring.bean.springberrybean.properties.SeparatorProperties
import it.giaquinto.springberry.spring.bean.springberrybean.properties.MemoryProperties
import it.giaquinto.springberry.spring.bean.springberrybean.properties.JavaProperties
import it.giaquinto.springberry.spring.bean.springberrybean.HardwareSoftwareProperties
import it.giaquinto.springberry.spring.bean.springberrybean.properties.OsProperties
import it.giaquinto.springberry.spring.bean.springberrybean.properties.RuntimeProperties
import it.giaquinto.springberry.spring.configuration.Identifier
import it.giaquinto.springberry.spring.configuration.Rest
import it.giaquinto.springberry.spring.configuration.RestRadix
import it.giaquinto.springberry.spring.configuration.SpringBerryConfiguration
import it.giaquinto.springberry.spring.controller.SpringBerryController
import it.giaquinto.springberry.spring.controller.SpringBerryController.Companion.radixControllerAcceptedRequest
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class AboutController : SpringBerryController<HardwareSoftwareProperties> {

    private val hardwareSoftwareProperties: HardwareSoftwareProperties by lazy {
        AnnotationConfigApplicationContext(SpringBerryConfiguration::class.java).getBean("hardwareSoftwareProperties") as HardwareSoftwareProperties
    }

    override val identifier: Identifier
        get() = this.javaClass.packageName

    override val uniqueRestRadix: RestRadix
        get() = AboutController.uniqueRestRadix


    @GetMapping("${AboutController.uniqueRestRadix}/$radixControllerAcceptedRequest")
    override fun controllerAcceptedMethod(): Array<HttpRequest?> =
        super.controllerAcceptedMethod()

    @GetMapping(AboutController.uniqueRestRadix)
    override fun defaultResponse() = hardwareSoftwareProperties

    @GetMapping("${AboutController.uniqueRestRadix}/java")
    fun javaProperties(): JavaProperties = hardwareSoftwareProperties.javaProperties

    @GetMapping("${AboutController.uniqueRestRadix}/memory")
    fun memoryProperties(): MemoryProperties = hardwareSoftwareProperties.memoryProperties

    @GetMapping("${AboutController.uniqueRestRadix}/os")
    fun osProperties(): OsProperties = hardwareSoftwareProperties.operatingSystem

    @GetMapping("${AboutController.uniqueRestRadix}/runtime")
    fun runtimeProperties(): RuntimeProperties = hardwareSoftwareProperties.runtimeProperties

    @GetMapping("${AboutController.uniqueRestRadix}/separator")
    fun separatorProperties(): SeparatorProperties = hardwareSoftwareProperties.separatorProperties

    @GetMapping("${AboutController.uniqueRestRadix}/thread")
    fun threadProperties(): ThreadProperties = hardwareSoftwareProperties.threadProperties

    @GetMapping("${AboutController.uniqueRestRadix}/user")
    fun userProperties(): UserProperties = hardwareSoftwareProperties.userProperties

    companion object {
        const val uniqueRestRadix: RestRadix = "about"
    }
}