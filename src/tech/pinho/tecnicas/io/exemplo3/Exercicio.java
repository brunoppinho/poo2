package tech.pinho.tecnicas.io.exemplo3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.Duration;
import java.time.Instant;
import java.time.Period;

public class Exercicio {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("erro.txt"))) {
            String linha;
            int contador = 0;
            while ((linha = br.readLine()) != null) {
                if (linha.contains("erro")) {
                    contador++;
                    System.out.println(linha);
                }
            }
            System.out.println("Foram " + contador + " linhas com erro.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
