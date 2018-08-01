package com.lang.util.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class CallbackListener<V> implements Runnable {

    final Future<V> future;
    final FutureCallback<? super V> callback;

    public CallbackListener(Future<V> future, FutureCallback<? super V> callback) {
        this.future = future;
        this.callback = callback;
    }

    public Future<V> getFuture() {
        return future;
    }

    @Override
    public void run() {
        System.out.println("CallbackListener run............");
        final V value;
        try {
            value = getDone(future);
            callback.onSuccess(value);
        } catch (ExecutionException e) {
            callback.onFailure(e.getCause());
        } catch (RuntimeException | Error e) {
            callback.onFailure(e);
        }
    }

    public static <V> V getDone(Future<V> future) throws ExecutionException {
        if (future.isDone()) {
            return getUninterruptibly(future);
        }
        throw new IllegalStateException(lenientFormat("Future was expected to be done: %s", future));
    }

    public static <V> V getUninterruptibly(Future<V> future) throws ExecutionException {
        boolean interrupted = false;
        try {
            while (true) {
                try {
                    return future.get();
                } catch (InterruptedException e) {
                    interrupted = true;
                }
            }
        } finally {
            if (interrupted) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static String lenientFormat(String template, Object... args) {
        template = String.valueOf(template); // null -> "null"

        args = args == null ? new Object[]{"(Object[])null"} : args;

        // start substituting the arguments into the '%s' placeholders
        StringBuilder builder = new StringBuilder(template.length() + 16 * args.length);
        int templateStart = 0;
        int i = 0;
        while (i < args.length) {
            int placeholderStart = template.indexOf("%s", templateStart);
            if (placeholderStart == -1) {
                break;
            }
            builder.append(template, templateStart, placeholderStart);
            builder.append(args[i++]);
            templateStart = placeholderStart + 2;
        }
        builder.append(template, templateStart, template.length());

        // if we run out of placeholders, append the extra args in square braces
        if (i < args.length) {
            builder.append(" [");
            builder.append(args[i++]);
            while (i < args.length) {
                builder.append(", ");
                builder.append(args[i++]);
            }
            builder.append(']');
        }

        return builder.toString();
    }
}
