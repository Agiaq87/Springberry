package it.giaquinto.springberry.model.log;

public abstract class LogMessageFactory {
    public static LogMessage direct(final String msg) {
        return new LogMessage(
                msg,
                LogOut.DIRECT
        );
    }

    public static LogMessage verbose(final String msg) {
        return new LogMessage(
                msg,
                LogOut.VERBOSE
        );
    }

    public static LogMessage warning(final String msg) {
        return new LogMessage(
                msg,
                LogOut.WARNING
        );
    }

    public static LogMessage error(final String msg) {
        return new LogMessage(
                msg,
                LogOut.ERROR
        );
    }
}
