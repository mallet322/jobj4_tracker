package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;

public class StartUITest {

    @Test
    public void whenAddItem() {
        Output out = new StubOutput();
        String[] answers = {"0", "Some Item", "1"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        UserAction[] actions = {new CreateAction(out), new ExitAction()};
        new StartUI(out).init(input, tracker, actions);
        Item actual = tracker.findAll()[0];
        Item expected = new Item("Some Item");
        Assert.assertEquals(expected.getName(), actual.getName());
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = new Item("Some Item");
        tracker.add(item);
        String[] answers = {"0", String.valueOf(item.getId()), "Replaced Item", "1"};
        Input input = new StubInput(answers);
        UserAction[] actions = {new ReplaceAction(out), new ExitAction()};
        new StartUI(out).init(input, tracker, actions);
        Item expected = new Item("Replaced Item");
        Item actual = tracker.findAll()[0];
        Assert.assertEquals(expected.getName(), actual.getName());
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = new Item(1,"Some Item");
        tracker.add(item);
        String[] answers = {"0", String.valueOf(item.getId()), "1"};
        Input input = new StubInput(answers);
        UserAction[] actions = {new DeleteAction(out), new ExitAction()};
        new StartUI(out).init(input, tracker, actions);
        Assert.assertNull(tracker.findById(item.getId()));
    }


}