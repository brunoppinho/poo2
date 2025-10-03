package tech.pinho.tecnicas.optional.exercicios;

import java.util.Arrays;
import java.util.List;

public class Main4 {

    record Aluno(String nome, double[] notas) {
    }

    public static void main(String[] args) {
        List<Aluno> alunos = List.of(
                new Aluno("Urias", new double[]{1.0, 2.5, 3.0}),
                new Aluno("Leo", new double[]{9.5, 7.5}),
                new Aluno("Carlúcio", new double[]{10.0, 9.5, 8.0, 7.0})
        );

        alunos.stream()
                .map(Aluno::notas)
                .flatMapToDouble(Arrays::stream)
                .average()
                .ifPresentOrElse(media -> System.out.println("Média geral das notas: " + media),
                        () -> System.out.println("Nenhuma nota disponível para calcular a média.")
                );
    }

}
