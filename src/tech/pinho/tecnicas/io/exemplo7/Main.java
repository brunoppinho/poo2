package tech.pinho.tecnicas.io.exemplo7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        List<String> linhas = Files.readAllLines(Paths.get("erro.txt"));
        linhas.forEach(System.out::println);
    }
}
