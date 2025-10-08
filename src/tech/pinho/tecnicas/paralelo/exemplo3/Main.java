package tech.pinho.tecnicas.paralelo.exemplo3;

public class Main {

    public static void main(String[] args) {
        Thread t = new Thread(() -> System.out.println("Hello World"));
        t.start();
    }
}
