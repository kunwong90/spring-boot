package com.lang.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

public interface ListeningExecutorService extends ExecutorService {

    @Override
    <T> ListenableFuture<T> submit(Callable<T> task);
}
