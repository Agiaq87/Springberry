package it.giaquinto.springberry.model.time

class ReadableTime(val seconds: Long) {
    val minutes: Long
    val hours: Long
    val days: Long
    val weeks: Long
    val months: Long
    val years: Long

    init {
        minutes = seconds / 60
        hours = minutes / 60
        days = hours / 24
        weeks = days / 7
        months = days / 30
        years = days / 365
    }

    override fun toString(): String {
        return "ReadableTime{" +
                "seconds=" + seconds +
                ", minutes=" + minutes +
                ", hours=" + hours +
                ", days=" + days +
                ", weeks=" + weeks +
                ", months=" + months +
                ", years=" + years +
                '}'
    }
}