package tech.pinho.tecnicas.io.exemplo10;

import java.io.IOException;
import java.nio.file.*;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        WatchService watchService = FileSystems.getDefault().newWatchService();

        // 2. Diretório a ser monitorado
        Path dir = Paths.get("src");

        // 3. Registrar eventos
        dir.register(watchService,
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_DELETE,
                StandardWatchEventKinds.ENTRY_MODIFY);

        System.out.println("Monitorando pasta: " + dir.toAbsolutePath());

        while (true) {
            WatchKey key = watchService.take(); // bloqueia até haver evento

            for (WatchEvent<?> event : key.pollEvents()) {
                WatchEvent.Kind<?> tipo = event.kind();
                Path arquivo = (Path) event.context();

                System.out.println("Evento: " + tipo + " no arquivo: " + arquivo);
            }

            boolean valido = key.reset();
            if (!valido) {
                break; // se diretório não for mais acessível
            }
        }
    }
}
