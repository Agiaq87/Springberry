package it.giaquinto.springberry.model.log;

public abstract class LogMessageFactory {

    public class Generic {
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

    public class Pin {
        public static LogMessage d(final String msg) {
            return new LogMessage(
                    msg,
                    LogOut.DIRECT
            );
        }

        public static LogMessage v(final String msg) {
            return new LogMessage(
                    msg,
                    LogOut.VERBOSE
            );
        }

        public static LogMessage w(final String msg) {
            return new LogMessage(
                    msg,
                    LogOut.WARNING
            );
        }

        public static LogMessage e(final String msg) {
            return new LogMessage(
                    msg,
                    LogOut.ERROR
            );
        }
    }
}
