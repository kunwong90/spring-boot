package com.lang.util.concurrent;

import java.util.concurrent.atomic.AtomicReference;

public abstract class InterruptibleTask<T> extends AtomicReference<T> implements Runnable {
}
