package it.giaquinto.springberry.model.system;

public enum SystemExit {

    TRIGGERED,
    FINISHED,
    REQUESTED,

    DEFAULT,

    ABNORMAL,
    CRITICAL,
    EXCEPTION,
    ERROR;

    public static int valueOf(final SystemExit systemExit) {
        return switch (systemExit) {
            case TRIGGERED -> 5;
            case FINISHED -> 2;
            case REQUESTED -> 1;
            case DEFAULT -> 0;
            case ABNORMAL -> -1;
            case CRITICAL -> -2;
            case EXCEPTION -> -5;
            case ERROR -> -10;
        };
    }
}
