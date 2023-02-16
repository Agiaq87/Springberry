package it.giaquinto.springberry.model.listener

interface OnErrorExecution<T> {
    fun error(exception: Exception?): T
}