package it.giaquinto.springberry.component

import it.giaquinto.springberry.model.log.LogMessage
import it.giaquinto.springberry.model.log.LogMessageFactory
import it.giaquinto.springberry.model.log.LogOut
import it.giaquinto.springberry.utils.file.FileUtils
import it.giaquinto.springberry.utils.time.TimeConverter
import org.slf4j.LoggerFactory
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import java.io.PrintWriter
import java.lang.reflect.Method
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.CompletableFuture

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
open class SpringBerryLoggerComponent private constructor() : AsyncUncaughtExceptionHandler {
    private val logger = LoggerFactory.getLogger("SpringBerry")
    private val simpleDateFormat: SimpleDateFormat = SimpleDateFormat()
    private val timeUnit: TimeConverter = TimeConverter.getInstance()
    private var outputFileWriter: PrintWriter?
    private var currentDate: Date
    private var lastLogMessage: LogMessage
    @Async
    open fun startLog(): CompletableFuture<LogMessage> {
        return writeLog(LogMessageFactory.Generic.direct("SpringBerry started"))
    }

    @Async
    open fun writeLog(logMessage: LogMessage): CompletableFuture<LogMessage> {
        if (lastLogMessage == logMessage) {
            return CompletableFuture.completedFuture(LogMessageFactory.Generic.verbose("Already printed"))
        }
        when (logMessage.logOut) {
            LogOut.DIRECT -> logger.trace(logMessage.message)
            LogOut.VERBOSE -> logger.info(logMessage.message)
            LogOut.WARNING -> logger.warn(logMessage.message)
            LogOut.ERROR -> logger.error(logMessage.message)
        }
        if (isCurrentDateNotUpdate) {
            initFile()
        }
        if (outputFileWriter != null) {
            outputFileWriter!!.write(
                String.format(
                    "%s - [%s] - %s\n",
                    simpleDateFormat.format(
                        logMessage.date
                    ),
                    logMessage.logOut.output,
                    logMessage.message
                )
            )
            outputFileWriter!!.flush()
            outputFileWriter!!.close()
        }
        lastLogMessage = logMessage
        return CompletableFuture.completedFuture(logMessage)
    }

    override fun handleUncaughtException(ex: Throwable, method: Method, vararg params: Any) {
        writeLog(
            LogMessageFactory.Generic.error(
                String.format(
                    "Ex: %s - Method: %s - Params: %s",
                    ex.toString(),
                    method.toString(),
                    params.toString()
                )
            )
        )
    }

    private fun initFile() {
        currentDate = Date()
        outputFileWriter = FileUtils.makeFile(directory, filePattern, currentDate)
    }

    private val isCurrentDateNotUpdate: Boolean
        private get() = timeUnit.distanceInDaysBetween(currentDate, Date()) != 0L

    init {
        FileUtils.makeDirectory(directory)
        currentDate = Date()
        outputFileWriter = FileUtils.makeFile(directory, filePattern, currentDate)
        simpleDateFormat.applyPattern(logPattern)
        lastLogMessage = LogMessageFactory.Generic.direct("")
    }

    companion object {
        @JvmStatic
        fun instance(): SpringBerryLoggerComponent {
            return SpringBerryLoggerComponent()
        }

        private const val logPattern = "dd-MM-yy-HH.mm.ss SSS"
        private const val filePattern = "dd-MM-yyyy"
        private const val directory = "log"
    }
}