package tech.pinho.tecnicas.async.exemplo2;

import tech.pinho.tecnicas.async.exemplo1.Main1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Exercicio {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        System.out.println("Iniciando...");

        Future<Integer> future = executorService.submit(() -> contador());
        Future<Integer> future2 = executorService.submit(() -> Main1.baixarArquivo(2));

        int quantidade = future.get();
        System.out.println("Quantidade: " + quantidade);
        future2.get();

        System.out.println("Fim do programa...");
    }

    public static int contador() {
        System.out.println("Iniciando contagem");

        int contador = 0;

        try {
            for (String linha : Files.readAllLines(Paths.get("erro.txt"))) {
                if (linha.contains("erro")) {
                    contador++;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Quantidade de linhas: " + contador);
        return contador;
    }
}
