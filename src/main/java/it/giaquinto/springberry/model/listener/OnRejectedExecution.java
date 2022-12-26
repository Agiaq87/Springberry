package it.giaquinto.springberry.model.listener;

import java.util.concurrent.RejectedExecutionException;

public interface OnRejectedExecution<T> {
    T rejected(final RejectedExecutionException rejectedExecutionException);
}
