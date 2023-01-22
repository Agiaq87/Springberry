package it.giaquinto.springberry.model.log;

import java.util.Date;
import java.util.Objects;

public final class LogMessage {

    private final String message;

    private final Date date;

    private final LogOut logOut;

    public LogMessage(String message) {
        this.message = message;
        this.date = new Date();
        this.logOut = LogOut.DIRECT;
    }

    public LogMessage(String message, LogOut logOut) {
        this.message = message;
        this.logOut = logOut;
        this.date = new Date();
    }

    public String getMessage() {
        return message;
    }

    public Date getDate() {
        return date;
    }

    public LogOut getLogOut() {
        return logOut;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LogMessage that)) return false;

        if (!message.equals(that.message)) return false;
        return logOut == that.logOut;
    }

    @Override
    public int hashCode() {
        int result = message.hashCode();
        result = 31 * result + date.hashCode();
        result = 31 * result + logOut.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "LogMessage{" +
                "message='" + message + '\'' +
                ", date=" + date +
                ", logOut=" + logOut +
                '}';
    }
}
