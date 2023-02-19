package it.giaquinto.springberry.spring.bean.springberrybean.logger

import it.giaquinto.springberry.spring.bean.SpringBerryBean
import it.giaquinto.springberry.spring.configuration.Identifier
import it.giaquinto.springberry.spring.model.logger.LogMessage
import it.giaquinto.springberry.spring.model.logger.LogOut
import it.giaquinto.springberry.utils.file.FileUtils
import it.giaquinto.springberry.utils.time.TimeConverter
import org.slf4j.LoggerFactory
import java.io.PrintWriter

class SpringBerryLoggerBean : SpringBerryBean {
    private val printWriter: PrintWriter? by lazy {
        FileUtils.makeFile(directory, filePattern, TimeConverter.now())
    }

    private val logger by lazy {
        LoggerFactory.getLogger("SpringBerry")
    }

    init {
        FileUtils.makeDirectory(directory)
    }

    suspend fun writeLog(logMessage: LogMessage): Unit = with(logMessage) {
        when (logOut) {
            LogOut.DIRECT -> logger.trace(logMessage.message)
            LogOut.VERBOSE -> {
                logger.info(logMessage.message)
                writeToFile(logMessage)
            }

            LogOut.WARNING -> {
                logger.warn(logMessage.message)
                writeToFile(logMessage)
            }

            LogOut.ERROR -> {
                logger.error(logMessage.message)
                writeToFile(logMessage)
            }
        }
    }

    private fun writeToFile(logMessage: LogMessage) = printWriter?.let {
        it.write(
            String.format(
                "%s - [%s] - %s\n",
                logMessage.date,
                logMessage.logOut.output,
                logMessage.message
            )
        )
        it.flush()
        it.close()
    }

    override fun packageIdentifier(): Identifier =
        this.javaClass.packageName

    companion object {
        const val filePattern = "dd-MM-yyyy"
        const val directory = "log"
    }
}