package tech.pinho.tecnicas.io.exemplo5;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        Path caminho = Paths.get("aulas/generics.md");
        System.out.println("Nome do diretorio: " + caminho.getFileName());
        System.out.println("Diretorio Pai " + caminho.getParent());
    }
}
