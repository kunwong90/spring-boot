package com.lang.util.concurrent;

import java.util.concurrent.Executor;

/**
 * @author kun.wang
 */
public abstract class AbstractFuture<V> implements ListenableFuture<V> {
    public void addListener(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e) {

        }
    }

    abstract static class TrustedFuture<V> extends AbstractFuture<V> {
        @Override
        public void addListener(Runnable listener, Executor executor) {
            super.addListener(listener, executor);
        }
    }

}
