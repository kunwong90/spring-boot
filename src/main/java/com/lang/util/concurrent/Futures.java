package com.lang.util.concurrent;


import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

public class Futures {

    public static <V> void addCallback(final ListenableFuture<V> future,
                                       final FutureCallback<V> callback,
                                       final Executor executor) {
        System.out.println(future.getClass());
        System.out.println(callback.getClass());
        System.out.println(executor.getClass());
        future.addListener(new CallbackListener<>(future, callback), executor);
    }




}
