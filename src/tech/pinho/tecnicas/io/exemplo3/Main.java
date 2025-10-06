package tech.pinho.tecnicas.io.exemplo3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("entrada.txt"))) {
            String linha;
            int contador = 0;
            while ((linha = br.readLine()) != null) {
                System.out.print("Linha: " + (++contador));
                System.out.println(linha);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
