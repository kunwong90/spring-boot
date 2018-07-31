package com.imooc;


import com.google.common.util.concurrent.*;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

public class ListenableFutureTest {

    public static void main(String[] args) throws InterruptedException {
        ListeningExecutorService pool = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));

        final ListenableFuture<String> future = pool.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(1000 * 2);
                return "Task done !";
            }
        });


        Futures.addCallback(future, new FutureCallback<String>() {
            @Override
            public void onSuccess(String result) {
                System.out.println(result);
            }

            @Override
            public void onFailure(Throwable t) {
                t.printStackTrace();
            }
        }, pool);

        Thread.sleep(5 * 1000);  //wait for task done

        pool.shutdown();
    }
}
