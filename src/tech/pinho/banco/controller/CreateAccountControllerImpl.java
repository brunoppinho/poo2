package tech.pinho.banco.controller;

import tech.pinho.banco.model.Account;
import tech.pinho.banco.model.AccountType;
import tech.pinho.banco.model.Owner;
import tech.pinho.banco.service.CreateOwnerService;
import tech.pinho.banco.service.OpenAccountService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class CreateAccountControllerImpl implements CreateAccountController, MenuAction {

    private final OpenAccountService openAccountService;
    private final CreateOwnerService createOwnerService;

    public CreateAccountControllerImpl(OpenAccountService openAccountService, CreateOwnerService createOwnerService) {
        this.openAccountService = openAccountService;
        this.createOwnerService = createOwnerService;
    }

    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o nome do usuário");
        String nome = sc.nextLine();

        System.out.print("Digite o CPF do usuário");
        String cpf = sc.nextLine();

        LocalDate nascimento = null;
        do {
            try {
                System.out.print("Digite a data de nascimento(Ex.: 2025-09-24 )");
                String data = sc.nextLine();
                nascimento = LocalDate.parse(data);
            } catch (DateTimeParseException e) {
                System.out.println("Formato inválido de data. Siga o exemplo (Ex.: 2025-09-24 )");
            }
        } while (nascimento == null);

        try {

            Owner owner = createOwnerService.execute(nome, cpf, nascimento);
            Account account = openAccountService.execute(owner, AccountType.CONTA_CORRENTE);
            System.out.println("A conta " + account + " foi criada com sucesso!");

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public String getTitle() {
        return "Abrir Conta";
    }
}
