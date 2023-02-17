package it.giaquinto.springberry.spring.controller.about

import it.giaquinto.springberry.spring.bean.springberrybean.properties.ThreadProperties
import it.giaquinto.springberry.spring.bean.springberrybean.properties.UserProperties
import it.giaquinto.springberry.spring.bean.springberrybean.properties.SeparatorProperties
import it.giaquinto.springberry.spring.bean.springberrybean.properties.MemoryProperties
import it.giaquinto.springberry.spring.bean.springberrybean.properties.JavaProperties
import it.giaquinto.springberry.spring.bean.springberrybean.HardwareSoftwareProperties
import it.giaquinto.springberry.spring.bean.springberrybean.properties.OsProperties
import it.giaquinto.springberry.spring.bean.springberrybean.properties.RuntimeProperties
import it.giaquinto.springberry.spring.configuration.Identifier
import it.giaquinto.springberry.spring.configuration.SpringBerryConfiguration
import it.giaquinto.springberry.spring.controller.SpringBerryController
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class AboutController: SpringBerryController<HardwareSoftwareProperties> {
    companion object {
        const val uniqueRestRadix: String = "about"
    }

    private val hardwareSoftwareProperties: HardwareSoftwareProperties

    init {
        AnnotationConfigApplicationContext(SpringBerryConfiguration::class.java).also {
            hardwareSoftwareProperties = it.getBean("hardwareSoftwareProperties") as HardwareSoftwareProperties
        }
    }

    override val identifier: Identifier
        get() = this.javaClass.packageName


    @GetMapping(AboutController.uniqueRestRadix)
    override fun defaultResponse() = hardwareSoftwareProperties

    @GetMapping("${AboutController.uniqueRestRadix}/java")
    fun javaProperties(): JavaProperties = hardwareSoftwareProperties.javaProperties

    @GetMapping("${AboutController.uniqueRestRadix}/memory")
    fun memoryProperties(): MemoryProperties = hardwareSoftwareProperties.memoryProperties

    @GetMapping("${AboutController.uniqueRestRadix}/os")
    fun osProperties(): OsProperties = hardwareSoftwareProperties.operatingSystem

    @GetMapping("${AboutController.uniqueRestRadix}/readableMemory")
    fun readableMemoryProperties(): OsProperties = hardwareSoftwareProperties.operatingSystem

    @GetMapping("${AboutController.uniqueRestRadix}/runtime")
    fun runtimeProperties(): RuntimeProperties = hardwareSoftwareProperties.runtimeProperties

    @GetMapping("${AboutController.uniqueRestRadix}/separator")
    fun separatorProperties(): SeparatorProperties = hardwareSoftwareProperties.separatorProperties

    @GetMapping("${AboutController.uniqueRestRadix}/thread")
    fun threadProperties(): ThreadProperties = hardwareSoftwareProperties.threadProperties

    @GetMapping("${AboutController.uniqueRestRadix}/user")
    fun userProperties(): UserProperties = hardwareSoftwareProperties.userProperties
}