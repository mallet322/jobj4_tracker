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
        return Arrays.copyOf(items, size);
    }

    public boolean replace(int id, Item item) {
        boolean result = false;
        int index = indexOf(id);
        if (index != -1) {
            item.setId(id);
            items[index] = item;
            result = true;
        }
        return result;
    }

    public boolean delete(int id) {
        boolean result = false;
        int index = indexOf(id);
        if (index != -1) {
            moveArrayElementsOnIndex(index, items);
            result = true;
        }
        return result;
    }

    private int indexOf(int id) {
        int result = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                result = index;
                break;
            }
        }
        return result;
    }

    private void moveArrayElementsOnIndex(int index, Item[] items) {
        int scrPos = index + 1;
        int length = size - index - 1;
        System.arraycopy(items, scrPos, items, index, length);
        items[size - 1] = null;
        size--;
    }

}