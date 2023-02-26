package it.giaquinto.springberry.spring.component

import it.giaquinto.springberry.common.logger.SpringBerryLoggerBean
import it.giaquinto.springberry.raspberry.controller.RaspberryGPIOManager
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.ModelAndView
import java.lang.Exception
import it.giaquinto.springberry.common.logger.model.LogMessage


@Component
class SpringBerryInterceptor(
    @Autowired private val raspberryGPIOManager: RaspberryGPIOManager,
    @Autowired private val springBerryLoggerBean: SpringBerryLoggerBean
): HandlerInterceptor {

    private val coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.IO)

    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        coroutineScope.launch {
            raspberryGPIOManager.raspberryLedExecutorInformer.onRequest(false)
        }
        coroutineScope.launch {
            springBerryLoggerBean.writeLog(LogMessage.Direct(request.remoteUser))
        }

        return super.preHandle(request, response, handler)
    }

    override fun postHandle(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any,
        modelAndView: ModelAndView?
    ) {
        coroutineScope.launch {
            raspberryGPIOManager.raspberryLedExecutorInformer.onResponse(false)
        }
        coroutineScope.launch {
            springBerryLoggerBean.writeLog(LogMessage.Direct("${response.status}"))
        }
        super.postHandle(request, response, handler, modelAndView)
    }

    override fun afterCompletion(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any,
        ex: Exception?
    ) {
        super.afterCompletion(request, response, handler, ex)
    }
}