package tech.pinho.tecnicas.stream.exemplo2;

import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
        Integer sum = integerStream
                .filter(i -> i % 2 == 0)
                .map(i -> i * i)
                .reduce(0, Integer::sum);
        System.out.println(sum);


        Stream.generate(() -> Math.random())
                .forEach(System.out::println);


    }
}
