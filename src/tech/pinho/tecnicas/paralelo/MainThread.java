package tech.pinho.tecnicas.paralelo;

import tech.pinho.tecnicas.paralelo.exemplo4.Contador;
import tech.pinho.tecnicas.paralelo.exemplo5.ContadorLock;
import tech.pinho.tecnicas.paralelo.exemplo6.TryLockContador;

import java.time.Duration;
import java.time.Instant;

public class MainThread {

    public static void main(String[] args) throws InterruptedException {

        TryLockContador contador = new TryLockContador();

        Runnable runnable = () -> {
            for (int i = 0; i < 100000; i++) {
                contador.incrementar();
            }
        };

        Thread thread = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        Instant begin = Instant.now();
        thread.start();
        thread2.start();

        thread2.join();
        thread.join();
        Instant end = Instant.now();

        System.out.println(contador.getValor());
        System.out.println(Duration.between(begin, end).toMillis());
    }
}
