package it.giaquinto.springberry.model.time

class TimeUnit(value: Long, readableValue: Long, orderMagnitudeTime: OrderMagnitudeTime) {
    val value: Long
    private val readableValue: Long
    private val orderMagnitudeTime: OrderMagnitudeTime

    init {
        this.name = name
        this.description = description
        this.dateTime = dateTime
        this.user = user
        this.value = value
        this.readableValue = readableValue
        this.orderMagnitudeTime = orderMagnitudeTime
    }
}