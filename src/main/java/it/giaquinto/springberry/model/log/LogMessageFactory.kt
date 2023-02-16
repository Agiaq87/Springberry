package it.giaquinto.springberry.model.log

abstract class LogMessageFactory {
    object Generic {
        fun direct(msg: String): LogMessage {
            return LogMessage(
                msg,
                LogOut.DIRECT
            )
        }

        fun verbose(msg: String): LogMessage {
            return LogMessage(
                msg,
                LogOut.VERBOSE
            )
        }

        fun warning(msg: String): LogMessage {
            return LogMessage(
                msg,
                LogOut.WARNING
            )
        }

        fun error(msg: String): LogMessage {
            return LogMessage(
                msg,
                LogOut.ERROR
            )
        }
    }

    object Pin {
        fun d(msg: String): LogMessage {
            return LogMessage(
                msg,
                LogOut.DIRECT
            )
        }

        fun v(msg: String): LogMessage {
            return LogMessage(
                msg,
                LogOut.VERBOSE
            )
        }

        fun w(msg: String): LogMessage {
            return LogMessage(
                msg,
                LogOut.WARNING
            )
        }

        fun e(msg: String): LogMessage {
            return LogMessage(
                msg,
                LogOut.ERROR
            )
        }
    }
}