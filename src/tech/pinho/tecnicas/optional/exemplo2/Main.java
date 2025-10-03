package tech.pinho.tecnicas.optional.exemplo2;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        Optional<String> nome = Optional.of("Nome");
        Optional<Integer> idade = Optional.ofNullable(null);
        Optional<LocalDate> dataNascimento = Optional.of(LocalDate.of(1990, 1, 1));
        System.out.println(nome.get());
        System.out.println(idade.orElse(0));
        System.out.println(dataNascimento.orElse(LocalDate.now()));

        idade.ifPresentOrElse(age -> System.out.println(age), () -> System.out.println("Não tem idade"));

        if (idade.isPresent()) {
            System.out.println(idade.get());
        } else {
            System.out.println("Não tem idade");
        }

    }
}
