package it.giaquinto.springberry.model.time;

public record TimeUnit(
        long value,
        long readableValue,
        OrderMagnitudeTime orderMagnitudeTime
) {}
