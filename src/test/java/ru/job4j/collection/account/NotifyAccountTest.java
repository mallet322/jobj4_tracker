package ru.job4j.collection.account;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class NotifyAccountTest {

    @Test
    public void sent() {
        List<Account> accounts = Arrays.asList(
                new Account("123", "Petr Arsentev", "eDer3432f"),
                new Account("142", "Petr Arsentev", "000001"),
                new Account("321", "Petr Arsentev", "2134ewqw1"),
                new Account("142", "Petr Arsentev", "000001")
        );
        HashSet<Account> expect = new HashSet<>(
                Arrays.asList(
                        new Account("123", "Petr Arsentev", "eDer3432f"),
                        new Account("142", "Petr Arsentev", "000001"),
                        new Account("321", "Petr Arsentev", "2134ewqw1")
                )
        );
        Assert.assertThat(NotifyAccount.sent(accounts), Matchers.is(expect));
    }

}