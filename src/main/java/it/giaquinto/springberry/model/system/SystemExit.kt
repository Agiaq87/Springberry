package it.giaquinto.springberry.model.system

enum class SystemExit {
    TRIGGERED, FINISHED, REQUESTED, DEFAULT, ABNORMAL, CRITICAL, EXCEPTION, ERROR;

    companion object {
        fun valueOf(systemExit: SystemExit): Int =
            when (systemExit) {
                TRIGGERED -> 5
                FINISHED -> 2
                REQUESTED -> 1
                DEFAULT -> 0
                ABNORMAL -> -1
                CRITICAL -> -2
                EXCEPTION -> -5
                ERROR -> -10
            }
    }
}