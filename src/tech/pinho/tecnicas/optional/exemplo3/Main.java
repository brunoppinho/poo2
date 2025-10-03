package tech.pinho.tecnicas.optional.exemplo3;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        Optional<Integer> number = obtemAleatorioPar();

        System.out.println(number);
        System.out.println(number.orElse(obtemAleatorio()));
        System.out.println(number.orElseGet(() -> obtemAleatorio()));
        System.out.println(number.orElse(0));


    }

    public static Optional<Integer> obtemAleatorioPar() {
        Integer aleatorio = (int) (Math.random() * 1000);
        if (aleatorio % 2 == 0) {
            return Optional.of(aleatorio);
        }
        return Optional.empty();
    }

    static Integer obtemAleatorio() {
        Integer numero = 0;
        System.out.println("O valor resultante é " + numero );
        return numero;
    }
}
