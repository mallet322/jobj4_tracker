package ru.job4j.tracker.util;

import java.util.Comparator;

import ru.job4j.tracker.model.Item;

public class SortByNameASC implements Comparator<Item> {

    @Override
    public int compare(Item o1, Item o2) {
        return o1.getName().compareTo(o2.getName());
    }

}
