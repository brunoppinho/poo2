package tech.pinho.tecnicas.io.exemplo7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Exercicio {

    public static void main(String[] args) throws IOException {
        List<String> linhas = Files.readAllLines(Paths.get("erro.txt"));
        int contador = 0;

        for (String linha : linhas) {
            if (linha.contains("erro")) {
                contador++;
                System.out.println(linha);
            }
        }

        System.out.println("Foram " + contador + " linhas com erro.");

    }

}
