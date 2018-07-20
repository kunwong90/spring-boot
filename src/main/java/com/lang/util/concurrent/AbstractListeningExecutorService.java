package com.lang.util.concurrent;

import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;

/**
 * @author kun.wang
 */
public abstract class AbstractListeningExecutorService extends AbstractExecutorService implements ListeningExecutorService {

    @Override
    public <T> ListenableFuture<T> submit(Callable<T> task) {
        return (ListenableFuture<T>) super.submit(task);
    }

    @Override
    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return TrustedListenableFutureTask.create(callable);
    }
}
