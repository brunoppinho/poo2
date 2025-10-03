package tech.pinho.tecnicas.optional.exercicios;

import java.util.Arrays;
import java.util.List;

public class Main2 {

    public static void main(String[] args) {
        List<String> frases = Arrays.asList(
                "Eu adoro quando um plano dá certo", // Esquadrão Classe A
                "Que a Força esteja com você", // Star Wars
                "Hasta la vista, baby", // O Exterminador do Futuro 2
                "Meu precioso", // O Senhor dos Anéis
                "Houston, temos um problema", // Apollo 13
                "A vida é como uma caixa de chocolates", // Forrest Gump
                "Você não pode lidar com a verdade", // Questão de Honra
                "Vou fazer uma oferta que ele não poderá recusar", // O Poderoso Chefão
                "Por que tão sério?", // Batman: O Cavaleiro das Trevas
                "Corre, Forrest, corre!", // Forrest Gump
                "Eu vejo pessoas mortas", // O Sexto Sentido
                "Você está falando comigo?", // Taxi Driver
                "Bond. James Bond", // 007
                "Ninguém põe Baby num canto", // Dirty Dancing
                "Ao infinito e além!", // Toy Story
                "Com grandes poderes vêm grandes responsabilidades", // Homem-Aranha
                "Liberdade!", // Coração Valente
                "Estou voando, Jack!", // Titanic
                "Não há lugar como o nosso lar", // O Mágico de Oz
                "Eu sou o rei do mundo!" // Titanic
        );

        frases.stream()
                .flatMap(a -> Arrays.stream(a.split(" ")))
                .filter(s -> !s.isBlank())
                .map(String::toLowerCase)
                .distinct()
                .forEach(System.out::println);

    }
}
