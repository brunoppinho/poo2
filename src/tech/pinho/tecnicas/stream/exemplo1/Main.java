package tech.pinho.tecnicas.stream.exemplo1;

import tech.pinho.tecnicas.funcional.exemplo8.Calculadora;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/*
Intermediárias (retornam outra Stream, são preguiçosas)
filter()
map()
sorted()
distinct()

Terminais (consomem a Stream, produzem resultado)
collect()
forEach()
count()
reduce()
anyMatch(), allMatch(), noneMatch()
 */
public class Main {

    public static void main(String[] args) {
        List<String> nomes = List.of("Bruno", "Ana", "Dante", "Sofia");

        List<String> filtrados = nomes
                .stream()
//                .filter(nome -> nome.startsWith("A"))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        System.out.println(filtrados);

        List<LocalDate> datas = List.of(
                LocalDate.of(1986, 3, 11),
                LocalDate.now(),
                LocalDate.of(2000, 1, 2),
                LocalDate.now().minusYears(18));

        Predicate<LocalDate> maiorDeIdade = data -> Period.between(data, LocalDate.now()).getYears() >= 18;

        System.out.println(datas.stream()
                .filter(maiorDeIdade)
                .count());

        List<Calculadora> operacoes = new ArrayList<>();
        Calculadora adicao = (x, y) -> x + y;
        Calculadora subtracao = (x, y) -> x - y;
        Calculadora multiplicacao = (x, y) -> x * y;
        Calculadora divisao = (x, y) -> x / y;

        operacoes.add(adicao);
        operacoes.add(subtracao);
        operacoes.add(multiplicacao);
        operacoes.add(divisao);

        System.out.println(operacoes.stream()
                .map(a -> a.operacao(3, 8))
                .reduce(Double::sum)
                .orElse(0.0));

    }
}
