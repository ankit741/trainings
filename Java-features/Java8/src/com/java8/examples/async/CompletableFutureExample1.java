package com.java8.examples.async;

import java.util.concurrent.*;
import java.util.function.Supplier;

public class CompletableFutureExample1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService= Executors.newFixedThreadPool(2);
        Runnable task=()->{
            System.out.println("hello");
        };
        Callable<String> task1=()->{
            return "hello";
        };
        Supplier<String> task3=()->{
            return "asyn supplier";
        };
        Future<?> output=executorService.submit(task);
        //by default sync task run in the fork join pool, is launched by fault with jvm in java8.
        // parallal stream also use same service.
        CompletableFuture<Void> completableFuture=CompletableFuture.runAsync(task);

        //explicit service
        CompletableFuture<Void> completableFuture2=CompletableFuture.runAsync(task,executorService);

        //supplier can't throw checked exception.
        CompletableFuture<String> completableFuture1=CompletableFuture.supplyAsync(task3,executorService);
        System.out.println(completableFuture1.get());


        executorService.shutdown();
    }
}
