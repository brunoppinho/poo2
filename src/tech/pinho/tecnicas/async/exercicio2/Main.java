package tech.pinho.tecnicas.async.exercicio2;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) {
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

        total = funcao4(paths);

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


}
