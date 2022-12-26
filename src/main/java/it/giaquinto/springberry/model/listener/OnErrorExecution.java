package it.giaquinto.springberry.model.listener;

public interface OnErrorExecution<T> {
    T error(final Exception exception);
}
