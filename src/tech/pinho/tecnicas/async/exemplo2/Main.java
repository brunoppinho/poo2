package tech.pinho.tecnicas.async.exemplo2;

import tech.pinho.tecnicas.async.exemplo1.Main1;

import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        System.out.println("Inicio do programa");

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<Integer> future = executorService.submit(() -> Main1.baixarArquivo(2));

        Thread.sleep(1000);
        future.get();
        System.out.println("Fim do programa");

    }
}
