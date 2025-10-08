package tech.pinho.tecnicas.async.exemplo5;

import java.util.concurrent.*;

public class Main {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
            return 10 * 2;
        }).thenAccept(resultado -> System.out.println("Resultado: " + resultado));

        Thread.sleep(2000);
        System.out.println("Finalizando a thread main");
    }


    void function2() {
    }
}
