package it.giaquinto.springberry.model.time;

public final class ReadableTime {

    private final long seconds;
    private final long minutes;
    private final long hours;
    private final long days;
    private final long weeks;
    private final long months;
    private final long years;

    public ReadableTime(final long seconds) {
        this.seconds = seconds;
        minutes = seconds/60;
        hours = minutes/60;
        days = hours/24;
        weeks = days/7;
        months = days/30;
        years = days/365;
    }

    public long getSeconds() {
        return seconds;
    }

    public long getMinutes() {
        return minutes;
    }

    public long getHours() {
        return hours;
    }

    public long getDays() {
        return days;
    }

    public long getWeeks() {
        return weeks;
    }

    public long getMonths() {
        return months;
    }

    public long getYears() {
        return years;
    }

    @Override
    public String toString() {
        return "ReadableTime{" +
                "seconds=" + seconds +
                ", minutes=" + minutes +
                ", hours=" + hours +
                ", days=" + days +
                ", weeks=" + weeks +
                ", months=" + months +
                ", years=" + years +
                '}';
    }
}
