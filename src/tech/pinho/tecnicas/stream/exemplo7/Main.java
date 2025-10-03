package tech.pinho.tecnicas.stream.exemplo7;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Collectors.groupingBy()
 */
public class Main {

    public static void main(String[] args) {
        Stream<String> nomes = Stream.of("Bruno", "Ana", "Dante", "Sofia");
        Map<Integer, List<String>> nomeMap = nomes.collect(Collectors.groupingBy(String::length));
        System.out.println(nomeMap);

    }
}
