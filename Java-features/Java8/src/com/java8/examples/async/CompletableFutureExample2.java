package com.ankit.example.java8.threading.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
CompletableFuture class implements  future  and completionstage interface
task has a state. may be running, completed normally, completed exceptionally */
public class CompletableFutureExample2 {

    public static void main(String[] args) throws InterruptedException {
/*        //nothing will be visible on console.
        //launched in common fork/join pool(mode.ForkJoinPool.commonPool-worker-1) and these are deamons thread and doesn't prevent jvm from exiting.
        CompletableFuture.runAsync(() -> {
            System.out.println("running task in async mode.");
        });
        // if main tread sleep, will be able to see
        Thread.sleep(3000);

        CompletableFuture.join()*/
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        CompletableFuture<Void> completableFuture = new CompletableFuture();
        Runnable task1 = () -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("hello from the task1" + Thread.currentThread().getName());
            completableFuture.complete(null);
        };
        CompletableFuture.runAsync(task1, executorService);
        System.out.println("before join");
        Void nil = completableFuture.join();
        System.out.println("done");
        executorService.shutdown();


    }
}
