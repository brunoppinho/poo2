package tech.pinho.tecnicas.async.exercicio2;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();

        List<Path> paths = List.of(Paths.get("dados1.txt"),
                Paths.get("dados2.txt"),
                Paths.get("dados3.txt"),
                Paths.get("dados4.txt"),
                Paths.get("dados5.txt"),
                Paths.get("dados6.txt"),
                Paths.get("dados7.txt")
        );
        Instant begin = Instant.now();
        long total = 0;

        long antes = runtime.totalMemory() - runtime.freeMemory();

        total = funcao5(paths);

        long depois = runtime.totalMemory() - runtime.freeMemory();
        System.out.printf("Memória usada pela tarefa: %.2f MB%n",
                (depois - antes) / 1024.0 / 1024.0);

        System.out.println("O total de linhas foi de " + total);
        Instant end = Instant.now();
        System.out.println("O tempo de execução foi de " + Duration.between(begin, end).toMillis() + "ms");
    }

    public static long funcao1(List<Path> paths) {
        List<CompletableFuture<Long>> tarefas = paths.stream()
                .map(arquivo -> CompletableFuture.supplyAsync(() -> ContadorDeLinhas.contar(arquivo)))
                .toList();

        return CompletableFuture.allOf(tarefas.toArray(new CompletableFuture[0]))
                .thenApply(v -> tarefas.stream().mapToLong(CompletableFuture::join).sum())
                .join();
    }

    public static long funcao2(List<Path> paths) {
        return paths.stream()
                .mapToLong(ContadorDeLinhas::contar)
                .sum();
    }

    public static long funcao3(List<Path> paths) {
        return paths.parallelStream()
                .mapToLong(ContadorDeLinhas::contar)
                .sum();
    }

    public static long funcao4(List<Path> paths) {
        return paths.stream()
                .map(path -> CompletableFuture.supplyAsync(() -> ContadorDeLinhas.contar(path)))
                .reduce((f1, f2) -> f2.thenCombine(f1, Long::sum))
                .orElseThrow()
                .join();

    }

    public static long funcao5(List<Path> paths) {
        try (ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor()) {
            return paths.stream()
                    .map(path -> executorService.submit(() -> ContadorDeLinhas.contar(path)))
                    .mapToLong(future -> {
                        try {
                            return future.get();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    })
                    .sum();
        }

    }

}
