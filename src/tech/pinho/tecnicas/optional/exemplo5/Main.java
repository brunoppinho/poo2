package tech.pinho.tecnicas.optional.exemplo5;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static tech.pinho.tecnicas.optional.exemplo3.Main.obtemAleatorioPar;

public class Main {

    public static void main(String[] args) {
        List<Aluno> alunos = new ArrayList<>();
        alunos.add(new Aluno("Urias", 1.5));
        alunos.add(new Aluno("Calebe", 0.8));
        alunos.add(new Aluno("John", 8.5));
        alunos.add(new Aluno("Elyne", 10));

        System.out.println(obtemNumeroDeAlunosQuePassaram(alunos));

        Optional<Aluno> zerado = alunos.stream()
                .filter(aluno -> aluno.nota() == 0)
                .findAny()
                .filter(aluno -> aluno.nome().length() > 10);

    }

    private static long obtemNumeroDeAlunosQuePassaram(List<Aluno> alunos) {
        return alunos.stream()
                .map(Aluno::nota)
                .filter(nota -> nota > 5)
                .count();
    }

    record Aluno(String nome, double nota) {

    }
}
