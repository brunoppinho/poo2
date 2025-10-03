package tech.pinho.tecnicas.stream.exemplo5;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
toList() → coleta em uma List
toSet() → coleta em um Set
joining(", ") → concatena elementos em uma String
groupingBy(Function) → agrupa elementos em Map<K, List<V>>
partitioningBy(Predicate) → divide elementos em dois grupos: true e false
 */
public class Main {

    public static void main(String[] args) {
        Stream<String> nomes = Stream.of("Bruno", "Ana", "Dante", "Sofia");

        List<String> nomeList = nomes.collect(Collectors.toList());
//        List<String> nomeList = nomes.collect(Collectors.toUnmodifiableList());

        nomeList.add("Urias");

        nomeList.forEach(s -> System.out.println(s));

        nomes = Stream.of("Bruno", "Ana", "Dante", "Sofia", "Bruno");
        nomeList = nomes.toList();
//        nomeList.add("Urias");
        nomeList.forEach(s -> System.out.println(s));

        nomes = Stream.of("Bruno", "Ana", "Dante", "Sofia", "Bruno");
        Set<String> nomeSet = nomes.collect(Collectors.toSet());
        nomeSet.forEach(s -> System.out.println(s));
    }
}
