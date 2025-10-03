package tech.pinho.tecnicas.stream.exemplo10;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> numeros = List.of(1, 5, 7, 12, 6, 4);

        if (!numeros.stream().filter(n -> n % 2 == 0).toList().isEmpty()) {
            System.out.println("Tem par");
        }

        if (numeros.stream().map(n -> n % 2 == 0).reduce(false, (a, b) -> a || b)) {
            System.out.println("Tem par");
        }

        if (numeros.stream().anyMatch(n -> n % 2 == 0)) {
            System.out.println("Tem par");
        }

        if (numeros.stream().noneMatch(n -> n % 13 == 0)) {
            System.out.println("Nenhum número é divisivel por 13");
        }

        if (numeros.stream().allMatch(n -> n % 2 == 0)) {
            System.out.println("Todos sào pares");
        } else {
            System.out.println("Nem todos os números são pares");
        }
    }
}
