package tech.pinho.tecnicas.funcional.exemplo6;

import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        LocalDate dataNascimento = LocalDate.of(1986, 3, 11);

        Predicate<LocalDate> maiorDeIdade = data -> Period.between(data, LocalDate.now()).getYears() >= 18;
        System.out.println(maiorDeIdade.test(dataNascimento));

        Function<Double, Double> cToF = c -> (c * 9/5) + 32;
        System.out.println("100°C em Fahrenheit: " + cToF.apply(100.0));

        Consumer<String> prefixado = nome -> System.out.println("Aluno: " + nome);
        prefixado.accept("Bruno");

        Supplier<String> geradorDeUuid = () -> UUID.randomUUID().toString();
        System.out.println(geradorDeUuid.get());

    }
}
