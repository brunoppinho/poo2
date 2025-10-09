package tech.pinho.tecnicas.async.exercicio2;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class ContadorDeLinhas {

    private static final String PALAVRA = "Java";

    public static long contar(Path arquivo) {
        try (Stream<String> linhas = Files.lines(arquivo)) {
            long count = linhas.filter(l -> l.contains(PALAVRA)).count();
            System.out.printf("Arquivo %-12s → %d ocorrência(s)%n", arquivo.getFileName(), count);
            Thread.sleep(50);
            return count;
        } catch (Exception e) {
            System.err.println("Erro lendo arquivo " + arquivo + ": " + e.getMessage());
            return 0;
        }
    }
}
