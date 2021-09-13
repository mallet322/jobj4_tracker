package ru.job4j.collection.usersort;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class UserTest {

    @Test
    public void whenAsc() {
        Set<User> users = new TreeSet<>();
        users.add(new User("Petr", 32));
        users.add(new User("Ivan", 31));
        Iterator<User> it = users.iterator();
        Assert.assertThat(it.next(), Matchers.is(new User("Ivan", 31)));
        Assert.assertThat(it.next(), Matchers.is(new User("Petr", 32)));
    }

    @Test
    public void whenComparePertVSIvan() {
        int rsl = new User("Petr", 32).compareTo(new User("Ivan", 31));
        Assert.assertThat(rsl, Matchers.greaterThan(0));
    }

}