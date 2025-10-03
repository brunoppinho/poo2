package tech.pinho.tecnicas.stream.exemplo8;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Stream<String> nomes = Stream.of("Bruno", "Ana", "Dante", "Sofia");

        Map<Boolean, List<String>> booleanListMap = nomes.collect(Collectors.partitioningBy(n -> n.length() > 3));
        System.out.println(booleanListMap);
    }
}
