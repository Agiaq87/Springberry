package it.giaquinto.springberry.model.contract.concurrent;

public interface OnErrorExecution<T> {
    T error(final Exception exception);
}
