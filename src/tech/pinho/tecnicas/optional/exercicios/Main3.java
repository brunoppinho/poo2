package tech.pinho.tecnicas.optional.exercicios;

import java.util.List;

public class Main3 {


    public static String encontrarPrimeiroNomeComA(List<String> nomes) {
        return nomes.stream()
                .filter(nome -> nome != null && nome.startsWith("A"))
                .findFirst()
                .map(String::toUpperCase)
                .orElse("Nenhum encontrado");
//        for (String nome : nomes) {
//            if (nome != null && !nome.isEmpty() && nome.charAt(0) == 'A') {
//                return nome.toUpperCase();
//            }
//        }
//        return "Nenhum encontrado";
    }

    public static void main(String[] args) {
        List<String> nomes = List.of("Carlos", "Beatriz", "Ana", "Amanda", "Bruno");

        String resultado = encontrarPrimeiroNomeComA(nomes);
        System.out.println(resultado);  // Deve imprimir "ANA"

        List<String> nomesSemA = List.of("Carlos", "Beatriz", "Bruno");
        String resultado2 = encontrarPrimeiroNomeComA(nomesSemA);
        System.out.println(resultado2); // Deve imprimir "Nenhum encontrado"
    }
}
