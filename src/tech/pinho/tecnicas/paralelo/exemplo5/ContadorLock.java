package tech.pinho.tecnicas.paralelo.exemplo5;

import java.util.concurrent.locks.ReentrantLock;

public class ContadorLock {

    int valor = 0;
    private final ReentrantLock lock = new ReentrantLock();

    public void incrementar() {
        lock.lock();
        try {
            valor++;
        } finally {
            lock.unlock();
        }
    }

    public int getValor() {
        return valor;
    }
}
