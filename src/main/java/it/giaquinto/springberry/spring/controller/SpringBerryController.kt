package it.giaquinto.springberry.spring.controller

import it.giaquinto.springberry.common.logger.SpringBerryLoggerBean
import it.giaquinto.springberry.spring.Identifier
import it.giaquinto.springberry.spring.Rest
import it.giaquinto.springberry.spring.RestRadix
import it.giaquinto.springberry.spring.model.SpringBerryModel
import it.giaquinto.springberry.spring.model.api.ApiResult
import it.giaquinto.springberry.spring.model.http.HttpRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

abstract class SpringBerryController<T> {

    abstract val identifier: Identifier

    abstract val uniqueRestRadix: RestRadix

    val springBerryLoggerBean: SpringBerryLoggerBean = SpringBerryLoggerBean

    abstract fun defaultResponse(): ApiResult<T>

    protected open fun controllerAcceptedMethod(): ApiResult<Array<HttpRequest?>?> =
        ApiResult.Success(_data = arrayOf(HttpRequest.GET))

    inline fun <reified ApiResult : SpringBerryModel> propagateApiResult(apiResult: ApiResult): ApiResult {
        runBlocking {
            launch(Dispatchers.IO) {
                springBerryLoggerBean.writeLog(apiResult.toLog())
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