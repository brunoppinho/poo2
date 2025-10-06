package tech.pinho.tecnicas.io.exemplo1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        try (FileInputStream fis = new FileInputStream("entrada.txt")) {
            int dado;
            while ((dado = fis.read()) != -1) {
                System.out.println(dado);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado.");
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo.");
        }
    }
}
