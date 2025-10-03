package tech.pinho.tecnicas.optional.exemplo7;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> nomes = List.of("Java", "Rust", "Php", "Lua");

        nomes.stream()
                .flatMapToInt(nome -> nome.chars())
                .forEach(ascii -> System.out.println(ascii));
    }
}
