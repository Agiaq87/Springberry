package it.giaquinto.springberry.spring.model.api

import it.giaquinto.springberry.common.logger.model.LogMessage
import it.giaquinto.springberry.spring.model.SpringBerryModel
import it.giaquinto.springberry.spring.model.http.HttpStatusCode
import it.giaquinto.springberry.spring.utils.time.TimeConverter

sealed class ApiResult<out T>(
    val name: String = "SpringBerry",
    val dateTime: String = TimeConverter.now(),
    val statusCode: HttpStatusCode?,
    private val status: ApiStatus,
    val message: String?,
    val data: T?,
) : SpringBerryModel {
    data class Success<out R>(
        private val _data: R?,
        private val _statusCode: HttpStatusCode? = if (_data != null) HttpStatusCode.OK else HttpStatusCode.NO_CONTENT
    ) : ApiResult<R>(
        status = ApiStatus.SUCCESS,
        data = _data,
        message = null,
        statusCode = _statusCode
    ) {
        override fun toLog(): LogMessage =
            if (_data is SpringBerryModel) _data.toLog() else LogMessage.Direct(ApiStatus.SUCCESS.toString())
    }

    data class Error(
        private val _message: String?,
        private val _statusCode: HttpStatusCode? = HttpStatusCode.BAD_REQUEST
    ) : ApiResult<Nothing>(
        status = ApiStatus.ERROR,
        data = null,
        message = _message,
        statusCode = _statusCode
    ) {
        override fun toLog(): LogMessage = LogMessage.Error(_message ?: "Error")
    }
}
