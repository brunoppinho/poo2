package tech.pinho.tecnicas.io.exemplo6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Main {

    public static void main(String[] args) throws IOException {
        Path origem = Paths.get("aulas/generics.md");
        Path destino = Paths.get("aulas/copia.md");

        Files.copy(origem, destino, StandardCopyOption.REPLACE_EXISTING);
        Files.move(destino, Paths.get("aulas/copia2.md"), StandardCopyOption.REPLACE_EXISTING);
        Files.delete(Paths.get("aulas/copia2.md"));
        Files.createFile(Paths.get("aulas/novo.md"));
    }
}
