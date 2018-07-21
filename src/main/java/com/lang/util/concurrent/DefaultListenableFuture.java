package com.lang.util.concurrent;

import java.util.concurrent.*;

public class DefaultListenableFuture<V> implements ListenableFuture<V> {

    private Future<V> future;

    public DefaultListenableFuture(Future<V> future) {
        System.out.println(future);
        this.future = future;
    }

    @Override
    public void addListener(Runnable listener, Executor executor) {
        System.out.println("DefaultListenableFuture addListener.......");
        System.out.println(listener.getClass());
        System.out.println(executor.getClass());
        executor.execute(listener);
    }

    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        System.out.println("DefaultListenableFuture cancel");
        return false;
    }

    @Override
    public boolean isCancelled() {
        System.out.println("DefaultListenableFuture isCancelled");
        return false;
    }

    @Override
    public boolean isDone() {
        System.out.println("DefaultListenableFuture isDone = " + future.isDone());
        return future.isDone();
    }

    @Override
    public V get() throws InterruptedException, ExecutionException {
        System.out.println("DefaultListenableFuture get = " + future.get());
        return future.get();
    }

    @Override
    public V get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        System.out.println("DefaultListenableFuture get with param");
        return null;
    }


}
