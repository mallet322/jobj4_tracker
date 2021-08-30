package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;

public class StartUITest {

    @Test
    public void whenAddItem() {
        String[] answers = {"Some answer"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        Item actual = tracker.findAll()[0];
        Item expected = new Item("Some answer");
        Assert.assertEquals(expected.getName(), actual.getName());
    }

}