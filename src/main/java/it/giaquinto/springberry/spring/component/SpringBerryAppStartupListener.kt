package it.giaquinto.springberry.spring.component

import it.giaquinto.springberry.common.logger.SpringBerryLoggerBean
import it.giaquinto.springberry.common.logger.model.LogMessage
import it.giaquinto.springberry.raspberry.controller.RaspberryGPIOManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.stereotype.Component

@Component
class SpringBerryAppStartupListener(
    @Autowired private val raspberryGPIOManager: RaspberryGPIOManager,
    @Autowired private val springBerryLoggerBean: SpringBerryLoggerBean
): ApplicationListener<ContextRefreshedEvent> {
    override fun onApplicationEvent(event: ContextRefreshedEvent) {
        raspberryGPIOManager.raspberryLedStatusInformer.onStart()
        springBerryLoggerBean.writeLog(LogMessage.Direct("SpringBerry successfully started"))
    }
}