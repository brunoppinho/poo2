package tech.pinho.tecnicas.funcional.exemplo8;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        List<Calculadora> operacoes = new ArrayList<>();
        Calculadora adicao = (x, y) -> x + y;
        Calculadora subtracao = (x, y) -> x - y;
        Calculadora multiplicacao = (x, y) -> x * y;
        Calculadora divisao = (x, y) -> x / y;

        operacoes.add(adicao);
        operacoes.add(subtracao);
        operacoes.add(multiplicacao);
        operacoes.add(divisao);

        System.out.println(adicao.operacao(1, 2));
        System.out.println(subtracao.operacao(1, 2));
        System.out.println(multiplicacao.operacao(1, 2));
        System.out.println(divisao.operacao(1, 2));

        operacoes.forEach(calculadora -> System.out.println(calculadora.operacao(8,3)));

        operacoes.stream()
                .map(calculadora -> calculadora.operacao(8,3))
                .forEach(System.out::println);





    }
}
