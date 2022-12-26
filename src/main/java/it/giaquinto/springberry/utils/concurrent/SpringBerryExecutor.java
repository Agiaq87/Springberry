package it.giaquinto.springberry.utils.concurrent;

import it.giaquinto.springberry.model.listener.OnErrorExecution;
import it.giaquinto.springberry.model.listener.OnRejectedExecution;
import it.giaquinto.springberry.model.listener.OnSuccessExecution;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

public final class SpringBerryExecutor {

    private static SpringBerryExecutor INSTANCE = null;

    private final ExecutorService executorService = Executors.newCachedThreadPool();

    private SpringBerryExecutor() {}

    public static SpringBerryExecutor getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SpringBerryExecutor();
        }

        return INSTANCE;
    }

    public <T> T execute(
            final Runnable runnable,
            final OnSuccessExecution<T> s,
            final OnRejectedExecution<T> r,
            final OnErrorExecution<T> e
     ) {
        try {
            executorService.execute(runnable);
            return s.success();
        } catch(final RejectedExecutionException rejectedExecutionException) {
            return r.rejected(rejectedExecutionException);
        } catch(final Exception exception) {
            return e.error(exception);
        }
    }
}
