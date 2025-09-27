package tech.pinho.tecnicas.datas.exemplo4;

import java.time.Instant;

public class Main {

    public static void main(String[] args) {
        Instant agora = Instant.now();
        System.out.println("Agora: " + agora);
        System.out.println("Epoch seconds: " + agora.getNano());
        Instant depois = Instant.now();
        System.out.println("Demorou  " + (depois.getNano() - agora.getNano()) + " nanosegundos");

    }
}
