package ru.job4j.tracker.store.impl;

import java.util.ArrayList;
import java.util.List;

import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.action.Observe;
import ru.job4j.tracker.store.Store;

public class MemTracker implements Store {

    private final List<Item> items = new ArrayList<>();

    private int ids = 1;

    @Override
    public void init() {
        add(new Item("first"));
        add(new Item("second"));
        add(new Item("third"));
        add(new Item("fourth"));
        add(new Item("fifth"));
        add(new Item("sixth"));
    }

    @Override
    public void close() {
        items.clear();
    }

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    @Override
    public Item findById(int id) {
        int index = indexOf(id);
        return (index != -1) ? items.get(index) : null;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (key.equals(item.getName())) {
                result.add(item);
            }
        }
        return result;
    }

    @Override
    public List<Item> findAll() {
        return List.copyOf(items);
    }

    @Override
    public void findAllByReact(Observe<Item> observe) throws InterruptedException {
        for (Item item : items) {
            Thread.sleep(1000);
            observe.receive(item);
        }
    }

    @Override
    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean result = index != -1;
        if (result) {
            item.setId(id);
            items.set(index, item);
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        int index = indexOf(id);
        boolean result = index != -1;
        if (result) {
            items.remove(index);
        }
        return result;
    }

    private int indexOf(int id) {
        int result = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                result = index;
                break;
            }
        }
        return result;
    }

}