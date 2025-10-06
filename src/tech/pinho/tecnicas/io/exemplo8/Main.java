package tech.pinho.tecnicas.io.exemplo8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        String fileName = "erro.txt";
        try (Stream<String> linhas = Files.lines(Paths.get(fileName))) {
            long numeroDeLinhas = linhas
                    .flatMap(a -> Arrays.stream(a.split(" ")))
                    .map(s -> s.replaceAll("[^a-zA-Z0-9]", ""))
                    .filter(s -> !s.isBlank())
                    .map(String::toLowerCase)
                    .filter(word -> word.equals("erro"))
                    .count();

            System.out.println("O arquivo '" + fileName + "' tem " + numeroDeLinhas + " linhas.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
