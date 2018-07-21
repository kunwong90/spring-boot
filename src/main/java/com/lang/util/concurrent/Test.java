package com.lang.util.concurrent;

import java.util.concurrent.*;

public class Test {
    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        ListeningExecutorService listeningExecutorService = MoreExecutors.listeningDecorator(threadPoolExecutor);
        ListenableFuture<String> future = listeningExecutorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                //模拟耗时
                Thread.sleep(1000 * 2);
                return "hello";
            }
        });
       Futures.addCallback(future, new FutureCallback<String>() {
           @Override
           public void onSuccess(String result) {
               System.out.println("result = " + result);
           }

           @Override
           public void onFailure(Throwable t) {
               System.err.println("error = " + t);
           }
       }, listeningExecutorService);
        System.out.println("=================================");
       Thread.sleep(2);
        System.out.println(System.currentTimeMillis() - start);
       listeningExecutorService.shutdown();


    }

}
