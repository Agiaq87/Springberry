package it.giaquinto.springberry.spring.component

import it.giaquinto.springberry.spring.model.logger.LogMessage
import it.giaquinto.springberry.spring.model.logger.LogOut
import it.giaquinto.springberry.utils.file.FileUtils
import it.giaquinto.springberry.utils.file.write
import it.giaquinto.springberry.utils.time.TimeConverter
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Lazy
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component
import java.io.File
import java.io.FileWriter

@Component
@Lazy
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
class SpringBerryLoggerBean {

    private val file: File
    private val fileWriter: FileWriter

    private val logger by lazy {
        LoggerFactory.getLogger("SpringBerry")
    }

    init {
        FileUtils.makeDirectory(directory)
        file = FileUtils.makeFile("$directory/${TimeConverter.now(false)}.log")
        fileWriter = FileUtils.makeWriter(file)
    }

    suspend fun writeLog(logMessage: LogMessage): Unit = with(logMessage) {
        when (logOut) {
            LogOut.DIRECT -> logger.trace(logMessage.message)
            LogOut.VERBOSE -> {
                logger.info(logMessage.message)
                fileWriter.write(logMessage)
            }

            LogOut.WARNING -> {
                logger.warn(logMessage.message)
                fileWriter.write(logMessage)
            }

            LogOut.ERROR -> {
                logger.error(logMessage.message)
                fileWriter.write(logMessage)
            }
        }
    }


    companion object {
        const val directory = "log"
    }
}