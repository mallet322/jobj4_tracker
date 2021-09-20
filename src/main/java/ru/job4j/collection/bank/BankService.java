package ru.job4j.collection.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс, описывает работу пользователя с банковскими сервисами.
 */
public class BankService {

    /**
     * Хранение пользователя и его банковских аккаунтов осуществляется в коллекции типа HashMap.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    private final List<Account> accounts = new ArrayList<>();

    /**
     * Метод, позволяющий добавить пользователя в коллекцию.
     * По умолчанию с пользователем добавляется пустая коллекция типа ArrayList.
     *
     * @param user
     *         Пользователь.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, accounts);
    }

    /**
     * Метод, позволяющий добавить аккаунт пользователю с помощью идентификатора (паспорт).
     *
     * @param passport
     *         Идентификатор пользователя.
     * @param account
     *         Аккаунт пользователя.
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод, позволяющий найти пользователя в коллекции users.
     *
     * @param passport
     *         Идентификатор пользователя.
     *
     * @return Найденный пользователь.
     */
    public User findByPassport(String passport) {
        return users.keySet()
                    .stream()
                    .filter(user -> passport.equals(user.getPassport()))
                    .findFirst()
                    .orElse(null);
    }

    /**
     * Метод, позволяющий найти пользователя в коллекции users по реквизитам.
     *
     * @param passport
     *         Идентификатор пользователя.
     * @param requisite
     *         Реквизиты пользователя.
     *
     * @return Найденный пользователь.
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user)
                        .stream()
                        .filter(account -> requisite.equals(account.getRequisite()))
                        .findFirst()
                        .orElse(null);
        }
        return null;
    }

    /**
     * Метод, позволяющий произвести трансфер денежных средств с одного аккаунта на другой.
     *
     * @param srcPassport
     *         Идентификатор пользователя, с которого списываются средства.
     * @param srcRequisite
     *         Реквизиты пользователя, с которого списываются средства.
     * @param destPassport
     *         Идентификатор пользователя, которому начисляются средства.
     * @param destRequisite
     *         Реквизиты пользователя, которому начисляются средства.
     * @param amount
     *         Сумма перевода денежных средств.
     *
     * @return Статус выполненного перевода.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }

}
