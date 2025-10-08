package tech.pinho.tecnicas.paralelo.exemplo10;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class Main {

    public static void main(String[] args) throws Exception {

        ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                // Criando um novo thread com nome customizado
                Thread thread = new Thread(r);
                thread.setName("Thread-Customizada-" + thread.getId());
                return thread;
            }
        };

        try (var executor = Executors.newThreadPerTaskExecutor(threadFactory)) {
            for (int i = 0; i < 1_000_000; i++) {
                int id = i;
                executor.submit(() -> {
                    Thread.sleep(1000); // simula I/O
                    System.out.println("Tarefa " + id);
                    return null;
                });
            }
        }
    }
}
