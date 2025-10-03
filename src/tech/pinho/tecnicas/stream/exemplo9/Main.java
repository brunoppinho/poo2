package tech.pinho.tecnicas.stream.exemplo9;

import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Stream<Integer> numeros = Stream.of(1, 2, 3, 4, 5, 6);
        numeros.forEach(System.out::println);

        numeros = IntStream.range(1, 7).boxed();
        numeros.forEach(System.out::println);
        int soma = IntStream.range(1, 7).sum();
        System.out.println(soma);

        OptionalDouble media = IntStream.range(1, 7).average();
        System.out.println(media);
    }
}
