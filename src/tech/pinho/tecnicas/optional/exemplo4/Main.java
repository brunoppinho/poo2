package tech.pinho.tecnicas.optional.exemplo4;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.Temporal;
import java.util.NoSuchElementException;
import java.util.Optional;

import static tech.pinho.tecnicas.optional.exemplo3.Main.obtemAleatorioPar;

public class Main {

    public static void main(String[] args) {
        Optional<Integer> number = obtemAleatorioPar();

//        try {
//            System.out.println(number.get());
//        } catch (NoSuchElementException e) {
//            throw new RuntimeException("Não possui um numero");
//        }

        System.out.println(number.orElseThrow(() -> new RuntimeException("Não possui um numero")));



    }
}
