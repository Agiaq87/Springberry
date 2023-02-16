package it.giaquinto.springberry.model.listener

interface OnSuccessExecution<T> {
    fun success(): T
}