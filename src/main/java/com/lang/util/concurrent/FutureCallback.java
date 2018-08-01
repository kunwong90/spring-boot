package com.lang.util.concurrent;

public interface FutureCallback<V> {

    /**
     *
     * @param result
     */
    void onSuccess(V result);

    /**
     *
     * @param t
     */
    void onFailure(Throwable t);
}
