package tech.pinho.tecnicas.paralelo.exemplo11;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        Instant begin = Instant.now();
        try (ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor()) {

            for (int i = 1; i <= 100_000; i++) {
                int id = i;
                executorService.submit(() -> {
                    sleep();
//                    System.out.println("Executing thread " + id + " na " + Thread.currentThread());
                });
            }
        }
        Instant end = Instant.now();

        System.out.println(Duration.between(begin, end).toMillis());

        ExecutorService executorService = Executors.newFixedThreadPool(1000);
        begin = Instant.now();

        for (int i = 1; i <= 100_000; i++) {
            int id = i;
            executorService.submit(() -> {
                sleep();
//                System.out.println("Executing thread " + id + " na " + Thread.currentThread().getName());
            });
        }

        executorService.shutdown();
        end = Instant.now();

        System.out.println(Duration.between(begin, end).toMillis());

    }

    static void sleep() {
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
