package com.lang.util.concurrent;


import java.util.concurrent.Executor;

public class Futures {

    public static <V> void addCallback(final ListenableFuture<V> future,
                                       final FutureCallback<V> callback,
                                       final Executor executor) {
        System.out.println(Futures.class.getName() + " " + future.getClass());
        System.out.println(Futures.class.getName() + " " + callback.getClass());
        System.out.println(Futures.class.getName() + " " + executor.getClass());
        future.addListener(new CallbackListener<>(future, callback), executor);
    }
}
