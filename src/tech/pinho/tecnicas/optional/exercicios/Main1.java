package tech.pinho.tecnicas.optional.exercicios;

import java.util.Optional;

public class Main1 {

    public static void main(String[] args) {
        System.out.println(obtemTamanho(Optional.of("Bruno")));
    }

    static Optional<Integer> obtemTamanho(Optional<String> nome) {
        return nome
                .map(String::toUpperCase)
                .map(String::length);
    }
}
