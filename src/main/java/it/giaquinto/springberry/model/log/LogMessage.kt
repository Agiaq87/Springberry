package it.giaquinto.springberry.model.log

import java.util.*

class LogMessage {
    val message: String
    val date: Date
    val logOut: LogOut

    constructor(message: String) {
        this.message = message
        date = Date()
        logOut = LogOut.DIRECT
    }

    constructor(message: String, logOut: LogOut) {
        this.message = message
        this.logOut = logOut
        date = Date()
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o !is LogMessage) return false
        return if (message != o.message) false else logOut == o.logOut
    }

    override fun hashCode(): Int {
        var result = message.hashCode()
        result = 31 * result + date.hashCode()
        result = 31 * result + logOut.hashCode()
        return result
    }

    override fun toString(): String {
        return "LogMessage{" +
                "message='" + message + '\'' +
                ", date=" + date +
                ", logOut=" + logOut +
                '}'
    }
}