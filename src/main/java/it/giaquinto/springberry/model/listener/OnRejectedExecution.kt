package it.giaquinto.springberry.model.listener

import java.util.concurrent.RejectedExecutionException

interface OnRejectedExecution<T> {
    fun rejected(rejectedExecutionException: RejectedExecutionException?): T
}