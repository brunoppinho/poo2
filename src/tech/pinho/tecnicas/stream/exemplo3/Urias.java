package tech.pinho.tecnicas.stream.exemplo3;

import java.util.stream.IntStream;

public class Urias {

    public static void main(String[] args) {
        // Nada termina. estou perdendo o ctrl
        IntStream.iterate(2, i -> i + 1)        // 2,3,4,...
                .filter(Urias::ehParFeliz)       // pares que ainda “sorriem” antes do vazio
                .forEachOrdered(System.out::println);
    }

    static boolean ehParFeliz(int n) {
        return (n & 1) == 0 && ehFeliz(n);
    }

    // Floyd: tartaruga e lebre num círculo inevitável. Se tocar 1, houve graça. Raro.
    static boolean ehFeliz(int n) {
        int lento = n, rapido = n;
        do {
            lento = passo(lento); rapido = passo(passo(rapido)); if (lento == 1 || rapido == 1) return true; // pequena saída da escuridão
        } while (lento != rapido);
        return false;     }

    // Passo “soma dos quadrados dos dígitos” — versão rápida sem alocações.
    static int passo(int x) {
        int s = 0;
        while (x > 0) {
            int d = x % 10;
            s += d * d;
            x /= 10;
        }
        return s;
    }

    /*
      static int passo(int n) {
        return String.valueOf(n).chars()
                .map(c -> c - '0')
                .map(d -> d * d)
                .reduce(0, Integer::sum);
    }
    */
}

