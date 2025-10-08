package tech.pinho.tecnicas.paralelo.exemplo6;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockContador {

    int valor = 0;
    private final ReentrantLock lock = new ReentrantLock();

    public void incrementar() {
        try {
            if (lock.tryLock(5, TimeUnit.MICROSECONDS)) {
//                System.out.println("Consegui o lock");
                try {
                    valor++;
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("Não foi possivel lock");
            }

        } catch (InterruptedException e) {
            System.out.println("Timeout");
            Thread.currentThread().interrupt();
        }

    }

    public int getValor() {
        return valor;
    }
}
