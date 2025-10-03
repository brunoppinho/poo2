package tech.pinho.banco.service;

import tech.pinho.banco.model.Account;
import tech.pinho.banco.model.AccountEntry;
import tech.pinho.banco.model.AccountEntryType;
import tech.pinho.banco.repository.AccountRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class WithdrawalGenerateTransactionServiceImpl implements GenerateTransactionService {

    private final AccountRepository accountRepository;

    public WithdrawalGenerateTransactionServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void execute(int accountNumber, BigDecimal amount, String description) {
        Account account = accountRepository.findById(accountNumber).orElseThrow();
        if (account == null) {
            System.out.println("Account not found");
            return;
        }
        if (account.getBalance().compareTo(amount) < 0) {
            System.out.println("Saldo insuficiente");
            return;
        }
        account.setBalance(account.getBalance().subtract(amount));
        AccountEntry entry = new AccountEntry();
        entry.setAmount(amount.negate());
        entry.setDescription(description);
        entry.setDate(LocalDateTime.now());
        entry.setType(AccountEntryType.WITHDRAWAL);
        entry.setSourceOrOrigin(null);
        account.getEntries().add(entry);

        System.out.println("O saldo final é de " + account.getBalance());
        System.out.println(account);
    }
}
