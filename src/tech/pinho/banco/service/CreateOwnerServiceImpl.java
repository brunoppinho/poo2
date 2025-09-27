package tech.pinho.banco.service;

import tech.pinho.banco.model.Owner;
import tech.pinho.banco.exception.MenorDeIdadeException;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Predicate;

public class CreateOwnerServiceImpl implements CreateOwnerService {

    private final Predicate<LocalDate> maiorDeIdade = data -> Period.between(data, LocalDate.now()).getYears() >= 18;

    @Override
    public Owner execute(String nome, String cpf, LocalDate nascimento) {
        Owner owner = new Owner();
        owner.setNome(nome);
        owner.setCpf(cpf);
        // Verificando a idade

        if (maiorDeIdade.test(nascimento)) {
            throw new MenorDeIdadeException();
        }
        return owner;
    }
}
