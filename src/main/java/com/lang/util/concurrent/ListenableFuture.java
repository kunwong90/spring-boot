package com.lang.util.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/**
 * @author kun.wang
 */
public interface ListenableFuture<V> extends Future<V> {

    /**
     *
     * @param listener
     * @param executor
     */
    void addListener(Runnable listener, Executor executor);
}
