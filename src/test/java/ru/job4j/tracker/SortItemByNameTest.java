package ru.job4j.tracker;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SortItemByNameTest {

    @Test
    public void sortItemASC() {
        List<Item> list = Arrays.asList(
                new Item(1, "Petr"),
                new Item(2, "Ivan")
        );
        list.sort(new SortItemByName());
        System.out.println(list);
    }

    @Test
    public void sortItemDesc() {
        List<Item> list = Arrays.asList(
                new Item(2, "Petr"),
                new Item(1, "Ivan")
        );
        list.sort(new SortItemByName().reversed());
        System.out.println(list);
    }
}
