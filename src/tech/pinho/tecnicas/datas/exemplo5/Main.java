package tech.pinho.tecnicas.datas.exemplo5;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Main {

    public static void main(String[] args) {
        LocalDateTime agora = LocalDateTime.now();

        ZonedDateTime sp = ZonedDateTime.of(agora, ZoneId.of("America/Sao_Paulo"));
        ZonedDateTime lisboa = ZonedDateTime.of(agora, ZoneId.of("Europe/Lisbon"));
        System.out.println("São Paulo: " + sp);
        System.out.println("Lisboa: " + lisboa);
        System.out.println("Agora " + ZonedDateTime.now().withZoneSameInstant(ZoneId.of("Europe/Lisbon")));
    }
}
