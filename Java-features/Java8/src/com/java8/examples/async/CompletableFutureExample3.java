package com.ankit.example.java8.threading.async;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class CompletableFutureExample3 {

    //pipeline of task
    public static void main(String[] args) throws InterruptedException {

        Supplier<List<Long>> supplyId = () -> {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return Arrays.asList(10L, 20L, 30L);
        };

        Function<List<Long>, List<User>> fetchUser = ids -> {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return ids.stream().map(User::new).collect(Collectors.toList());
        };

        Consumer<List<User>> printer = (user) -> {
            System.out.println(Thread.currentThread().getName());
            user.forEach(System.out::println);
        };
         //chaining

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        CompletableFuture<List<Long>> listCompletableFuture = CompletableFuture.supplyAsync(supplyId);
        listCompletableFuture.thenApply(fetchUser)
                .thenAcceptAsync(printer,executorService);

        Thread.sleep(6000);
        executorService.shutdown();
    }

    public static class User {
        private Long id;
        private String name;

        public User() {
        }

        public User(Long id) {
            this.id = id;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    '}';
        }
    }
}
