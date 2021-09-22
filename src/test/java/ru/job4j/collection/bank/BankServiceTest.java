package ru.job4j.collection.bank;

import java.util.Optional;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class BankServiceTest {

    @Test
    public void addUser() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        Assert.assertThat(bank.findByPassport("3434"), Matchers.is(Optional.of(user)));
    }

    @Test
    public void whenEnterInvalidPassport() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        Assert.assertNull(bank.findByRequisite("34", "5546"));
    }

    @Test
    public void addAccount() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        bank.findByRequisite("3434", "5546")
            .ifPresent(account -> Assert.assertThat(account.getBalance(), Matchers.is(150D)));
    }

    @Test
    public void add2Accounts() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("1111", 150D));
        bank.addAccount(user.getPassport(), new Account("1122", 300D));
        bank.findByRequisite("3434", "1111")
            .ifPresent(account -> Assert.assertThat(account.getBalance(), Matchers.is(150D)));
        bank.findByRequisite("3434", "1122")
            .ifPresent(account -> Assert.assertThat(account.getBalance(), Matchers.is(300D)));
    }

    @Test
    public void transferMoney() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        bank.addAccount(user.getPassport(), new Account("113", 50D));
        bank.transferMoney(user.getPassport(),  "5546",
                           user.getPassport(),  "113",
                           150D);
        bank.findByRequisite(user.getPassport(), "5546")
            .ifPresent(account -> Assert.assertThat(account.getBalance(), Matchers.is(0D)));
        bank.findByRequisite(user.getPassport(), "113")
            .ifPresent(account -> Assert.assertThat(account.getBalance(), Matchers.is(200D)));
    }

}