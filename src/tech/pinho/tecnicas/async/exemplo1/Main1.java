package tech.pinho.tecnicas.async.exemplo1;

public class Main1 {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Inicio do programa");
        Thread t = new Thread(() -> baixarArquivo(1));
        Thread t2 = new Thread(() -> baixarArquivo(2));
        Thread t3 = new Thread(() -> baixarArquivo(3));
        t.start();
        t2.start();
        t3.start();
        t.join();
        t2.join();
        t3.join();
        System.out.println("Fim do programa");
    }

    public static int baixarArquivo(int numero) {
        System.out.println("Iniciando o download do arquivo..." + numero);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Arquivo baixado com sucesso!");
        return numero;
    }
}
