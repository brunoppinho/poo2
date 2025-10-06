package tech.pinho.tecnicas.io.exemplo9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        Path raiz = Paths.get("src");
        try (Stream<Path> walk = Files.walk(raiz)) {
            walk.filter(Files::isRegularFile)
                    .map(Path::getFileName)
                    .map(Path::toString)
                    .filter(f -> f.endsWith(".java"))
                    .forEach(System.out::println);
        }
    }
}
