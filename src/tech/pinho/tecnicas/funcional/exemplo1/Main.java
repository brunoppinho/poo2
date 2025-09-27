package tech.pinho.tecnicas.funcional.exemplo1;

import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        System.out.println(soma(1, 2));

        Function<Integer, Double> dobrar = x -> x + 1.0;
        System.out.println(dobrar.apply(5)); // 10

        Runnable r = () -> System.out.println("Executando");

        Runnable r2 = new Runnable() {
            public void run() {
                System.out.println("Executando");
            }
        };
//        r.run();
    }

    static int soma(int a, int b) {
        return a + b;
    }
}
