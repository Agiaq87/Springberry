package it.giaquinto.springberry.common.logger.model

import it.giaquinto.springberry.spring.utils.time.TimeConverter
import jakarta.servlet.http.HttpServletRequest

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

   companion object {
       fun fromHttpServletRequest(httpServletRequest: HttpServletRequest): LogMessage {
            val authenticated = httpServletRequest.remoteUser != null

           return Direct("authenticated: $authenticated")
       }
   }
}