package tech.pinho.tecnicas.paralelo.exemplo1;

public class Main {

    public static void main(String[] args) {
        Thread t = new MinhaThread();
        System.out.println("Executando main thread" + Thread.currentThread().getName());

        t.start();

        for (int i = 0; i < 5000; i++) {

        }
        System.out.println("Ainda executando" + Thread.currentThread().getName());

    }

}

class MinhaThread extends Thread {

    @Override
    public void run() {
        System.out.println("Executando minha thread" + Thread.currentThread().getName());
    }
}
