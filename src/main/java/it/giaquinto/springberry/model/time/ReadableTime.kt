package it.giaquinto.springberry.model.time

data class ReadableTime(val seconds: Long) {
    val minutes: Long = seconds / 60
    val hours: Long = minutes / 60
    val days: Long = hours / 24
    val weeks: Long = days / 7
    val months: Long = days / 30
    val years: Long = days / 365
}