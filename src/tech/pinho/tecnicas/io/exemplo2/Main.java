package tech.pinho.tecnicas.io.exemplo2;

import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        try (FileWriter fw = new FileWriter("Arquivo2.txt")) {
            fw.write("Tem alguem triste hoje?");
            fw.write("Hello World");
        }

    }
}
