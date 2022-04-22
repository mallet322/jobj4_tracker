package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.util.SortByNameASC;
import ru.job4j.tracker.util.SortByNameDESC;

public class SortByNameTest {

    @Test
    public void sortItemASC() {
        List<Item> list = Arrays.asList(
                new Item(2, "Petr"),
                new Item(1, "Ivan")
        );
        list.sort(new SortByNameASC());
        Iterator<Item> iterator = list.iterator();
        Assert.assertThat(iterator.next(), Matchers.is(new Item(1, "Ivan")));
        Assert.assertThat(iterator.next(), Matchers.is(new Item(2, "Petr")));
    }

    @Test
    public void sortItemDesc() {
        List<Item> list = Arrays.asList(
                new Item(1, "Ivan"),
                new Item(2, "Petr")
        );
        list.sort(new SortByNameDESC());
        Iterator<Item> iterator = list.iterator();
        Assert.assertThat(iterator.next(), Matchers.is(new Item(2, "Petr")));
        Assert.assertThat(iterator.next(), Matchers.is(new Item(1, "Ivan")));
    }
}
