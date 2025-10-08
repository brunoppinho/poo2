package tech.pinho.tecnicas.async.exemplo3;

import tech.pinho.tecnicas.async.exemplo2.Exercicio;

import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> Exercicio.contador());

        future.join();
        System.out.println("Fim do programa");
    }
}
