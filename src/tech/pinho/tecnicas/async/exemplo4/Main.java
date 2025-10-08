package tech.pinho.tecnicas.async.exemplo4;

import java.util.concurrent.CompletableFuture;

/*
supplyAsync() → inicia tarefa com retorno.
thenApply() → transforma o resultado.
thenAccept() → consome o resultado final.
join() → aguarda o término (sem checked exception).

 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        var asd = CompletableFuture.supplyAsync(() -> {
            System.out.println("Baixando arquivo");
            return "Resultado";
        }).thenApply(dados -> {
            System.out.println("Resultado: " + dados);
            return dados.toUpperCase();
        }).thenAccept(result -> {
            System.out.println("Resultado: " + result);
        });

        System.out.println("Fazendo algo");
        Thread.sleep(1000);
        System.out.println("Terminei algo");
        asd.join();
    }
}
