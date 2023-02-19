package it.giaquinto.springberry.spring.model.logger

import it.giaquinto.springberry.utils.time.TimeConverter

sealed class LogMessage(
    val message: String,
    val date: String,
    val logOut: LogOut
) {
    data class Direct(
        private val _message: String
    ) : LogMessage(
        message = _message,
        date = TimeConverter.now(),
        logOut = LogOut.DIRECT
    )

    data class Verbose(
        private val _message: String
    ) : LogMessage(
        message = _message,
        date = TimeConverter.now(),
        logOut = LogOut.VERBOSE
    )

    data class Warning(
        private val _message: String
    ) : LogMessage(
        message = _message,
        date = TimeConverter.now(),
        logOut = LogOut.WARNING
    )

    data class Error(
        private val _message: String
    ) : LogMessage(
        message = _message,
        date = TimeConverter.now(),
        logOut = LogOut.ERROR
    )
}