package ru.job4j.collection.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {

    private final Map<User, List<Account>> users = new HashMap<>();
    private final List<Account> accounts = new ArrayList<>();

    public void addUser(User user) {
        users.putIfAbsent(user, accounts);
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        for (Map.Entry<User, List<Account>> entry : users.entrySet()) {
            if (entry.getKey() == user) {
                if (!entry.getValue().contains(account)) {
                    entry.getValue().add(account);
                }
            }
        }
    }

    public User findByPassport(String passport) {
        User result = null;
        for (User key : users.keySet()) {
            if (passport.equals(key.getPassport())) {
                result = key;
            }
        }
        return result;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account result = null;
        User user = findByPassport(passport);
        for (Map.Entry<User, List<Account>> entry : users.entrySet()) {
            if (entry.getKey() == user) {
                for (Account account : entry.getValue()) {
                    if (requisite.equals(account.getRequisite())) {
                        result = account;
                    }
                }
            }
        }
        return result;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && srcAccount.getBalance() >= amount) {
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }

}
