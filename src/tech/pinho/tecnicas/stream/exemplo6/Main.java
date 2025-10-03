package tech.pinho.tecnicas.stream.exemplo6;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Stream<String> nomes = Stream.of("Bruno", "Ana", "Dante", "Sofia");

        String resultado = nomes.collect(Collectors.joining(" ", "Nome: ", " Pinho"));
        System.out.println(resultado);

    }
}
