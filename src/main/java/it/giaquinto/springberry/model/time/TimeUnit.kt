package it.giaquinto.springberry.model.time

data class TimeUnit(private val value: Long, private val readableValue: Long, private val orderMagnitudeTime: OrderMagnitudeTime) {
    val current: String
        get() = "$readableValue ${orderMagnitudeTime.name}"
}