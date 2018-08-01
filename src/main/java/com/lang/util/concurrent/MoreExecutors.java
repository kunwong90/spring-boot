package com.lang.util.concurrent;

import java.util.concurrent.ExecutorService;

public class MoreExecutors {

    public static ListeningExecutorService listeningDecorator(ExecutorService delegate) {
        return new ListeningDecorator(delegate);
    }
}
