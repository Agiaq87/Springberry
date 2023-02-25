package it.giaquinto.springberry

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class SpringBerryApplication {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(SpringBerryApplication::class.java, *args)
        }
    }
}