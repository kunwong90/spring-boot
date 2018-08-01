package com.lang.util.concurrent;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author kun.wang
 */
public class ListeningDecorator implements ListeningExecutorService {

    private final ExecutorService delegate;

    ListeningDecorator(ExecutorService delegate) {
        this.delegate = checkNotNull(delegate);
    }

    public static <T> T checkNotNull(T reference) {
        if (reference == null) {
            throw new NullPointerException();
        }
        return reference;
    }

    @Override
    public void shutdown() {
        this.delegate.shutdown();
    }

    @Override
    public List<Runnable> shutdownNow() {
        return null;
    }

    @Override
    public boolean isShutdown() {
        return false;
    }

    @Override
    public boolean isTerminated() {
        return false;
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public <T> ListenableFuture<T> submit(Callable<T> task) {
        System.out.println(getClass().getName() + " submit.....");
        System.out.println(task);
        Future<T> future = this.delegate.submit(task);
        return new DefaultListenableFuture<>(future);
    }

    @Override
    public <T> Future<T> submit(Runnable task, T result) {
        return null;
    }

    @Override
    public Future<?> submit(Runnable task) {
        return null;
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
        return null;
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException {
        return null;
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
        return null;
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return null;
    }

    @Override
    public void execute(Runnable command) {
        System.out.println("ListeningDecorator execute");
        this.delegate.execute(command);
    }
}
