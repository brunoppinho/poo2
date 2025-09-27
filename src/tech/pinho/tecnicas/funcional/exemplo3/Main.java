package tech.pinho.tecnicas.funcional.exemplo3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        List<String> textos = new ArrayList<>();
        textos.add("Texto");
        textos.add("Texto2");
        textos.add("Texto3");
        textos.add("Texto4");
        textos.add("Texto5");

        for (String texto : textos) {
            System.out.println(texto);
        }

        for (int i = 0; i < textos.size(); i++) {
            System.out.println(textos.get(i));
        }

        Consumer<String> imprimir = y -> System.out.println(y);
        imprimir = y -> System.out.println("Colocando um prefixo: " + y);

        textos.forEach(y -> System.out.println("Colocando um prefixo: " + y));
    }
}
