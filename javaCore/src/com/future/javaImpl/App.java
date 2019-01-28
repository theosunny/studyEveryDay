package com.future.javaImpl;

import java.util.concurrent.*;

public class App {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> future = new FutureTask<>(new RealData("name"));
        ExecutorService executor = Executors.newFixedThreadPool(1);
        executor.submit(future);
        System.out.println("请求完毕" );
        try {
            TimeUnit.SECONDS.sleep(2);

        } catch (InterruptedException e) {

        }
        System.out.println("数据：="+future.get());
    }
}
