package it.giaquinto.springberry.common.logger

import it.giaquinto.springberry.common.logger.model.LogMessage
import it.giaquinto.springberry.spring.utils.file.FileUtils
import it.giaquinto.springberry.spring.utils.file.write
import it.giaquinto.springberry.spring.utils.time.TimeConverter
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component
import java.io.FileWriter


@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
class SpringBerryLoggerBean {

    private val D: FileWriter
    private val V: FileWriter
    private val W: FileWriter
    private val E: FileWriter
    private val U: FileWriter

    private val logger by lazy {
        LoggerFactory.getLogger("SpringBerry")
    }

    init {
        FileUtils.makeDirectory("log")
        FileUtils.makeDirectory("log/D")
        FileUtils.makeDirectory("log/V")
        FileUtils.makeDirectory("log/W")
        FileUtils.makeDirectory("log/E")
        U = FileUtils.makeWriter(FileUtils.makeFile("log/${TimeConverter.now(false)}.log"))
        D = FileUtils.makeWriter(FileUtils.makeFile("log/D/${TimeConverter.now(false)}.log"))
        V = FileUtils.makeWriter(FileUtils.makeFile("log/V/${TimeConverter.now(false)}.log"))
        W = FileUtils.makeWriter(FileUtils.makeFile("log/W/${TimeConverter.now(false)}.log"))
        E = FileUtils.makeWriter(FileUtils.makeFile("log/E/${TimeConverter.now(false)}.log"))
    }

    suspend fun writeLog(logMessage: LogMessage): Unit =
        when (logMessage.logOut) {
            it.giaquinto.springberry.common.logger.model.LogOut.DIRECT -> {
                logger.trace(logMessage.message)
                U.write(logMessage)
                D.write(logMessage)
            }

            it.giaquinto.springberry.common.logger.model.LogOut.VERBOSE -> {
                logger.info(logMessage.message)
                U.write(logMessage)
                V.write(logMessage)
            }

            it.giaquinto.springberry.common.logger.model.LogOut.WARNING -> {
                logger.warn(logMessage.message)
                U.write(logMessage)
                W.write(logMessage)
            }

            it.giaquinto.springberry.common.logger.model.LogOut.ERROR -> {
                logger.error(logMessage.message)
                U.write(logMessage)
                E.write(logMessage)
            }
        }
}