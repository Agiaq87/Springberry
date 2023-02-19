package it.giaquinto.springberry.spring.controller

import it.giaquinto.springberry.spring.bean.springberrybean.logger.SpringBerryLoggerBean
import it.giaquinto.springberry.spring.configuration.Identifier
import it.giaquinto.springberry.spring.configuration.Rest
import it.giaquinto.springberry.spring.configuration.RestRadix
import it.giaquinto.springberry.spring.configuration.SpringBerryConfiguration
import it.giaquinto.springberry.spring.model.api.ApiResult
import it.giaquinto.springberry.spring.model.http.HttpRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.springframework.context.annotation.AnnotationConfigApplicationContext

abstract class SpringBerryController<T> {

    abstract val identifier: Identifier

    abstract val uniqueRestRadix: RestRadix

    private val springBerryLoggerBean: SpringBerryLoggerBean by lazy {
        AnnotationConfigApplicationContext(SpringBerryConfiguration::class.java).getBean("springBerryLogger") as SpringBerryLoggerBean
    }

    abstract fun defaultResponse(): ApiResult<T>

    protected open fun controllerAcceptedMethod(): ApiResult<Array<HttpRequest?>?> =
        ApiResult.Success(_data = arrayOf(HttpRequest.GET))

    inline fun <reified ApiResult> propagateApiResult(apiResult: ApiResult): ApiResult {
        runBlocking {
            launch(Dispatchers.IO) {

            }
            launch(Dispatchers.IO) {

            }
        }
        return apiResult
    }

    companion object {
        const val radixControllerAcceptedRequest: Rest = "httpAcceptedMethod"
    }

}