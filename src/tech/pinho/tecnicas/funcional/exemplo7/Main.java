package tech.pinho.tecnicas.funcional.exemplo7;

import java.util.function.*;

public class Main {

    public static void main(String[] args) {
        // BiPredicate: verificar se soma de dois números é maior que 10
        BiPredicate<Integer, Integer> somaMaiorQue10 = (a, b) -> (a + b) > 10;
        System.out.println(somaMaiorQue10.test(5, 7)); // true

        // BiFunction: concatenar nome e sobrenome
        BiFunction<String, String, String> nomeCompleto = (nome, sobrenome) -> nome + " " + sobrenome;
        System.out.println(nomeCompleto.apply("Bruno", "Pinho"));

        // BiConsumer: imprimir chave e valor
        BiConsumer<String, Integer> mostrar = (chave, valor) -> System.out.println(chave + " = " + valor);
        mostrar.accept("Idade", 30);

        // UnaryOperator: dobrar um número
        UnaryOperator<Integer> dobrar = x -> x * 2;
        System.out.println(dobrar.apply(10)); // 20

        // BinaryOperator: pegar o maior número
        BinaryOperator<Integer> max = Integer::max;
        System.out.println(max.apply(5, 9)); // 9
    }
}
