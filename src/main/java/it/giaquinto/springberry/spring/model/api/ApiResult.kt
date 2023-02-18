package it.giaquinto.springberry.spring.model.api

sealed class ApiResult<out T> (
    val status: ApiStatus,
    val message: String?,
    val statusCode: Int?,
    val timestamp: Long = System.currentTimeMillis(),
    val data: T?,
) {
    data class Success<out R>(private val _data: R?, private val _statusCode: Int? = 200) : ApiResult<R>(
        status = ApiStatus.SUCCESS,
        data = _data,
        message = "SpringBerry information",
        statusCode = _statusCode
    )

    data class Error(private val _message: String, private val _statusCode: Int? = 200): ApiResult<Nothing>(
        status = ApiStatus.ERROR,
        data = null,
        message = _message,
        statusCode = _statusCode
    )
}
