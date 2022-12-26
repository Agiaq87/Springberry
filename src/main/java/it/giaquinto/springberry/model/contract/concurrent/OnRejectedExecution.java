package it.giaquinto.springberry.model.contract.concurrent;

import java.util.concurrent.RejectedExecutionException;

public interface OnRejectedExecution<T> {
    T rejected(final RejectedExecutionException rejectedExecutionException);
}
