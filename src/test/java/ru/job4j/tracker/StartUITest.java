package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;

public class StartUITest {

    @Test
    public void whenAddItem() {
        String[] answers = {"Some Item"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        Item actual = tracker.findAll()[0];
        Item expected = new Item("Some Item");
        Assert.assertEquals(expected.getName(), actual.getName());
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("Some Item");
        tracker.add(item);
        String[] answers = {String.valueOf(item.getId()), "Replaced Item"};
        Input input = new StubInput(answers);
        StartUI.replaceItem(input, tracker);
        Item expected = new Item("Replaced Item");
        Item actual = tracker.findAll()[0];
        Assert.assertEquals(expected.getName(), actual.getName());
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item(1,"Some Item");
        tracker.add(item);
        String[] answers = {String.valueOf(item.getId())};
        Input input = new StubInput(answers);
        StartUI.deleteItem(input, tracker);
        Assert.assertNull(tracker.findById(item.getId()));
    }

}