package tech.pinho.tecnicas.paralelo.exemplo7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.execute(() -> System.out.println("Tarefa 1"));
        executorService.execute(() -> System.out.println("Tarefa 2"));
        executorService.execute(() -> System.out.println("Tarefa 3"));
        executorService.execute(() -> System.out.println("Tarefa 4"));
        executorService.execute(() -> System.out.println("Tarefa 5"));

        executorService.shutdown();
    }

}
