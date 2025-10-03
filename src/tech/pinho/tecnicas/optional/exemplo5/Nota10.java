package tech.pinho.tecnicas.optional.exemplo5;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Nota10 {

    public static void main(String[] args) {
        List<Aluno> alunos = new ArrayList<>();
        alunos.add(new Aluno("Urias", 1.5));
        alunos.add(new Aluno("Calebe", 0.8));
        alunos.add(new Aluno("John", 8.5));
        alunos.add(new Aluno("Elyne", 10));

        alunos.stream()
                .filter(a -> a.nota() == 10.0)
                .findFirst()
                .map(Aluno::nome)
                .ifPresentOrElse(nome -> System.out.println("Parabéns " + nome),
                        () -> System.out.println("Ninguém") );

    }

    record Aluno(String nome, double nota) {

    }
}
