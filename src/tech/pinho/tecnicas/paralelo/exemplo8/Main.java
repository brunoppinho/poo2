package tech.pinho.tecnicas.paralelo.exemplo8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(7);

        for (int i = 1; i <= 10; i++) {
            int id = i;
            executorService.submit(() -> {
                System.out.println("Executing thread " + id + " na " + Thread.currentThread().getName());
            });
        }

        executorService.shutdown();
    }
}
