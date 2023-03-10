package it.giaquinto.springberry.spring.controller.about

import it.giaquinto.springberry.spring.annotation.SpringBerryRestController
import it.giaquinto.springberry.spring.Identifier
import it.giaquinto.springberry.spring.RestRadix
import it.giaquinto.springberry.spring.bean.springberrybean.HardwareSoftwareProperties
import it.giaquinto.springberry.spring.bean.springberrybean.properties.*
import it.giaquinto.springberry.spring.configuration.SpringBerryConfiguration
import it.giaquinto.springberry.spring.controller.SpringBerryController
import it.giaquinto.springberry.spring.model.api.ApiResult
import it.giaquinto.springberry.spring.model.http.HttpRequest
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.web.bind.annotation.GetMapping

/**
 * Controller for take information on SpringBerry status
 * Perform an investigation on
 * - Hardware component TODO
 * - - Pin status TODO
 * - - Protocols ports status TODO
 * - - Ethernet status TODO
 * - - WiFi status if enabled TODO
 * - - CPU status TODO
 * - - Memory status (DONE)
 * - - Other hardware attached to SpringBerry TODO
 * - Software component TODO
 * - - Java status (DONE)
 * - - OS status (DONE)
 * - - Runtime status (DONE)
 *
 */
@SpringBerryRestController
class AboutController : SpringBerryController<HardwareSoftwareProperties>() {

    private val hardwareSoftwareProperties: HardwareSoftwareProperties by lazy {
        AnnotationConfigApplicationContext(SpringBerryConfiguration::class.java).getBean("hardwareSoftwareProperties") as HardwareSoftwareProperties
    }

    override val identifier: Identifier
        get() = this.javaClass.packageName

    override val uniqueRestRadix: RestRadix
        get() = AboutController.uniqueRestRadix


    @GetMapping("${AboutController.uniqueRestRadix}/$radixControllerAcceptedRequest")
    override fun controllerAcceptedMethod(): ApiResult<Array<HttpRequest?>?> =
        super.controllerAcceptedMethod()

    @GetMapping(AboutController.uniqueRestRadix)
    override fun defaultResponse(): ApiResult<HardwareSoftwareProperties> =
        ApiResult.Success(_data =hardwareSoftwareProperties)

    @GetMapping("${AboutController.uniqueRestRadix}/java")
    fun javaProperties(): ApiResult<JavaProperties> =
        ApiResult.Success(_data = hardwareSoftwareProperties.javaProperties)

    @GetMapping("${AboutController.uniqueRestRadix}/memory")
    fun memoryProperties(): ApiResult<MemoryProperties> =
        ApiResult.Success(_data = hardwareSoftwareProperties.memoryProperties)

    @GetMapping("${AboutController.uniqueRestRadix}/os")
    fun osProperties(): ApiResult<OsProperties> =
        ApiResult.Success(_data =hardwareSoftwareProperties.operatingSystem)

    @GetMapping("${AboutController.uniqueRestRadix}/runtime")
    fun runtimeProperties(): ApiResult<RuntimeProperties> =
        ApiResult.Success(_data =hardwareSoftwareProperties.runtimeProperties)

    @GetMapping("${AboutController.uniqueRestRadix}/separator")
    fun separatorProperties(): ApiResult<SeparatorProperties> =
        ApiResult.Success(_data =hardwareSoftwareProperties.separatorProperties)

    @GetMapping("${AboutController.uniqueRestRadix}/thread")
    fun threadProperties(): ApiResult<ThreadProperties> =
        ApiResult.Success(_data =hardwareSoftwareProperties.threadProperties)

    @GetMapping("${AboutController.uniqueRestRadix}/user")
    fun userProperties(): ApiResult<UserProperties> =
        ApiResult.Success(_data =hardwareSoftwareProperties.userProperties)

    companion object {
        const val uniqueRestRadix: RestRadix = "about"
    }
}