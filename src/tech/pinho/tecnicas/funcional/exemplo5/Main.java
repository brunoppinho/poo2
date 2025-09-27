package tech.pinho.tecnicas.funcional.exemplo5;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/*
Predicate<T> → recebe um valor e retorna boolean.
Function<T,R> → recebe um valor de T e retorna um R.
Consumer<T> → recebe um valor e não retorna nada.
Supplier<T> → não recebe nada, mas retorna um valor.
 */
public class Main {

    public static void main(String[] args) {
        String palavra = "Java";
        Predicate<String> estaVazio = s -> s.isEmpty();
        System.out.println("Está vazio? " + estaVazio.test(palavra));

        Function<String, Integer> tamanho = s -> s.length();
        System.out.println("Tamanho: " + tamanho.apply(palavra));

        Consumer<String> imprimir = s -> System.out.println(s);
        imprimir.accept(palavra);

        Supplier<Double> aleatorio = () -> Math.random();
        System.out.println("aleatorio: " + aleatorio.get());
    }
}
