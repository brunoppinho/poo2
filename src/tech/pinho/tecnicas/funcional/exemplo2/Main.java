package tech.pinho.tecnicas.funcional.exemplo2;

import java.util.function.Predicate;

public class Main {

    static void verificarNumero(int n, Predicate<Integer> regra) {
        System.out.println("Resultado: " + regra.test(n));
    }

    public static void main(String[] args) {
        verificarNumero(10, x -> x > 5);   // true
        verificarNumero(3, x -> x % 2 == 0); // false
        verificarNumero(3, x -> x % 3 == 0);

    }
}
