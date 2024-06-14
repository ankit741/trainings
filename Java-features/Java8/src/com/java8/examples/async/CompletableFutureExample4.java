package com.java8.examples.async;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

// exception handling , cf can handle exception without try catch block..
public class CompletableFutureExample4 {

    public static void main(String[] args) throws InterruptedException {

        Supplier<List<Long>> supplyId = () -> {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            throw new RuntimeException();
        };

        Function<List<Long>, List<CompletableFutureExample3.User>> fetchUser = ids -> {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return ids.stream().map(CompletableFutureExample3.User::new).collect(Collectors.toList());
        };

        Consumer<List<CompletableFutureExample3.User>> printer = (user) -> {
            System.out.println(Thread.currentThread().getName());
            user.forEach(System.out::println);
        };
        //chaining

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        CompletableFuture<List<Long>> listCompletableFuture = CompletableFuture.supplyAsync(supplyId);
        listCompletableFuture.thenApply(fetchUser)
                .exceptionally(exception-> new ArrayList<>())
                .thenAcceptAsync(printer,executorService);

        Thread.sleep(6000);
        System.out.println(listCompletableFuture.isDone());
        System.out.println(listCompletableFuture.isCompletedExceptionally());
        executorService.shutdown();
    }
}
