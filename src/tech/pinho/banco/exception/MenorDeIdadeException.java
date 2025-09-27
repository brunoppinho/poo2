package tech.pinho.banco.exception;

public class MenorDeIdadeException extends RuntimeException {

    public MenorDeIdadeException() {
        super("O proprietário não tem 18 anos ou mais.");
    }
}
