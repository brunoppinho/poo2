package tech.pinho.tecnicas.stream.exemplo11;

import java.time.Instant;
import java.util.List;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        List<Integer> lista = IntStream.rangeClosed(1, 7_000_000).boxed().toList();

        Instant begin = Instant.now();
        long somaSequencial = lista.stream().reduce(0, Integer::sum);
        Instant end = Instant.now();

        System.out.println("A soma é " + somaSequencial);
        System.out.println("O tempo gasto foi de " + (end.toEpochMilli() - begin.toEpochMilli()));

        begin = Instant.now();
        long somaParalela = lista.parallelStream().reduce(0, Integer::sum);
        end = Instant.now();

        System.out.println("A soma é " + somaParalela);
        System.out.println("O tempo gasto foi de " + (end.toEpochMilli() - begin.toEpochMilli()));
    }
}
