package tech.pinho.tecnicas.optional.exemplo1;

import tech.pinho.banco.model.Owner;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        Owner owner = new Owner();
        owner.setNome("Bruno");
        Optional<String> nome = getNome(owner);
        Optional<String> sobrenome = Optional.ofNullable(null);
        Optional<String> email = Optional.empty();
        System.out.println(nome);
        System.out.println(sobrenome);
        System.out.println(email);
    }

    static Optional<String> getNome(Owner owner) {
        if(owner == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(owner.getNome());

    }
}
