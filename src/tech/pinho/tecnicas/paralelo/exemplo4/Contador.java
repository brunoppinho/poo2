package tech.pinho.tecnicas.paralelo.exemplo4;

public class Contador {
    int valor = 0;

    public synchronized void incrementar() {
        valor++;
    }

    public int getValor() {
        return valor;
    }
}
