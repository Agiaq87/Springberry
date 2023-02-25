package it.giaquinto.springberry

import it.giaquinto.springberry.raspberry.controller.RaspberryGPIOManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class SpringBerryApplication(@Autowired private val raspberryGPIOManager: RaspberryGPIOManager) {

    init {
        raspberryGPIOManager.startVisualInformer()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(SpringBerryApplication::class.java, *args)
        }
    }
}