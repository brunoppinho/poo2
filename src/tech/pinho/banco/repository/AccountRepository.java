package tech.pinho.banco.repository;

import tech.pinho.banco.model.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountRepository implements Repository<Account, Integer> {

    private List<Account> accounts = new ArrayList<>();
    private static AccountRepository instance;

    private AccountRepository() {

    }

    public static AccountRepository getInstance() {
        if (instance == null) {
            instance = new AccountRepository();
        }
        return instance;
    }

    @Override
    public Account save(Account account) {
        account.setNumber(accounts.size() + 1);
        accounts.add(account);
        return account;
    }

    @Override
    public Account update(Account obj) {
        accounts.set(obj.getNumber() - 1, obj);
        return obj;
    }

    @Override
    public List<Account> findAll() {
        return accounts;
    }

    @Override
    public Optional<Account> findById(Integer id) {
        try {
            return Optional.ofNullable(accounts.get(id - 1));
        } catch (IndexOutOfBoundsException e) {
            return Optional.empty();
        }
    }
}
