package com.lang.util.concurrent;

public interface FutureCallback<V> {

    void onSuccess(V result);

    void onFailure(Throwable t);
}
