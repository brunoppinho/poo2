package tech.pinho.tecnicas.stream.exemplo12;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        List<Integer> lista = IntStream.rangeClosed(1, 100_000).boxed().toList();

        List<Integer> resultado = new ArrayList<>();

//        Instant begin = Instant.now();
//        lista.parallelStream().forEach(a -> resultado.add(a));
//        Instant end = Instant.now();
//
//        System.out.println("O tempo gasto foi de " + (end.toEpochMilli() - begin.toEpochMilli()));
//        System.out.println("O tamanho do resultado: " + resultado.size());


        Instant begin = Instant.now();
        lista.parallelStream().forEach(System.out::println);
        Instant end = Instant.now();

        System.out.println("O tempo gasto foi de " + (end.toEpochMilli() - begin.toEpochMilli()));
        System.out.println("O tamanho do resultado: " + resultado.size());
    }
}
