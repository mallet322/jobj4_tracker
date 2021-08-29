package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {

    private final Item[] items = new Item[100];

    private int ids = 1;

    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findByName(String key) {
        Item[] itemsWithKey = new Item[size];
        int temp = 0;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (key.equals(item.getName())) {
                itemsWithKey[temp] = item;
                temp++;
            }
        }
        return Arrays.copyOf(itemsWithKey, temp);
    }

    public Item[] findAll() {
        Item[] itemsWithoutNull = new Item[size];
        int temp = 0;
        for (Item item : items) {
            if (item != null) {
                itemsWithoutNull[temp] = item;
                temp++;
            }
        }
        return Arrays.copyOf(itemsWithoutNull, temp);
    }

}