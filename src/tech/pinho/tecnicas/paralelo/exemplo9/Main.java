package tech.pinho.tecnicas.paralelo.exemplo9;

import tech.pinho.banco.model.Owner;

public class Main {

    public static void main(String[] args) {
        Owner owner1 = new Owner();
        owner1.setNome("Bruno");
        Owner owner2 = new Owner();
        owner2.setNome("Dante");

        Thread t1 = new Thread(() -> {
            synchronized (owner1) {
                System.out.println("Nome1: " + owner1.getNome());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (owner2) {
                    System.out.println("Nome1: " + owner2.getNome());
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (owner1) {
                System.out.println("Nome2: " + owner2.getNome());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (owner2) {
                    System.out.println("Nome2: " + owner1.getNome());
                }

            }
        });

        t1.start();
        t2.start();
    }
}
