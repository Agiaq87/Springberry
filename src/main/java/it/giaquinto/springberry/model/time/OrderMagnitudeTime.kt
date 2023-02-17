package it.giaquinto.springberry.model.time;

public enum OrderMagnitudeTime {
    FEMTO,
    PICO,
    NANO,
    MICRO,
    MILLI,
    SECOND,
    KILO,
    MEGA,
    GIGA,
    TERA,
    PETA,
    EXA,
    ZETTA;

    public static OrderMagnitudeTime toNext(final OrderMagnitudeTime value) {
        return switch (value) {
            case FEMTO -> PICO;
            case PICO -> NANO;
            case NANO -> MICRO;
            case MICRO -> MILLI;
            case MILLI -> SECOND;
            case SECOND -> KILO;
            case KILO -> MEGA;
            case MEGA -> GIGA;
            case GIGA -> TERA;
            case TERA -> TERA;
            case PETA -> PETA;
            case EXA -> ZETTA;
            case ZETTA -> null;
        };
    }
}
