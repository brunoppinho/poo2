package tech.pinho.tecnicas.stream.exemplo4;

/*
filter(Predicate) → filtra elementos
map(Function) → transforma elementos
sorted() → ordena
distinct() → remove duplicados
limit(n) → pega os primeiros n
skip(n) → pula os primeiros n
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/*
forEach(Consumer) → iteração final
collect(Collector) → coleta em lista, set, mapa
count() → conta elementos
reduce(...) → reduz a um valor
findFirst(), findAny() → obtém elementos opcionais
anyMatch(), allMatch(), noneMatch() → verificações booleanas
 */
public class Main {

    public static void main(String[] args) {
        Stream<String> nomes = Stream.of("Bruno", "Ana", "Dante", "Sofia");

        // Funcional
        nomes.sorted()
                .skip(1)
                .filter(str -> str.length() > 4)
                .limit(2)
                .map(String::toUpperCase)
                .forEach(s -> System.out.println(s));

        // Procedural
        List<String> nomes2 = Arrays.asList("Ana", "Pedro", "José", "Maria", "Paula", "Lucas");

        // Ordena a lista
        Collections.sort(nomes2);

        // Pule o primeiro elemento
        List<String> sublist = nomes2.subList(1, nomes2.size());

        // Filtra as strings com mais de 4 caracteres
        List<String> filteredList = new ArrayList<>();
        for (String nome : sublist) {
            if (nome.length() > 4) {
                filteredList.add(nome);
            }
        }

        // Limita a 2 elementos
        if (filteredList.size() > 2) {
            filteredList = filteredList.subList(0, 2);
        }

        // Converte para maiúsculas e imprime
        for (String nome : filteredList) {
            System.out.println(nome.toUpperCase());
        }
    }
}
