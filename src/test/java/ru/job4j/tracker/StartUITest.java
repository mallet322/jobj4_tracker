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
        Item item = new Item(1, "Some Item");
        tracker.add(item);
        String[] answers = {"0", String.valueOf(item.getId()), "1"};
        Input input = new StubInput(answers);
        UserAction[] actions = {new DeleteAction(out), new ExitAction()};
        new StartUI(out).init(input, tracker, actions);
        Assert.assertNull(tracker.findById(item.getId()));
    }

    @Test
    public void whenShowAllItems() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = new Item(1, "Some Item");
        tracker.add(item);
        String[] answers = {"0", "1"};
        Input input = new StubInput(answers);
        UserAction[] actions = {new FindAllAction(out), new ExitAction()};
        new StartUI(out).init(input, tracker, actions);
        Item[] expectedArray = {item};
        Assert.assertArrayEquals(expectedArray, tracker.findAll());
    }

    @Test
    public void whenFindItemById() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = new Item(1, "Some Item");
        tracker.add(item);
        String[] answers = {"0", String.valueOf(item.getId()), "1"};
        Input input = new StubInput(answers);
        UserAction[] actions = {new FindByIdAction(out), new ExitAction()};
        new StartUI(out).init(input, tracker, actions);
        Assert.assertEquals(item, tracker.findById(item.getId()));
    }

    @Test
    public void whenFindItemsByName() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item0 = new Item(1, "Some Item");
        Item item1 = new Item(2, "Some Item");
        Item item2 = new Item(3, "Some Item");
        tracker.add(item0);
        tracker.add(item1);
        tracker.add(item2);
        String[] answers = {"0", String.valueOf(item0.getName()), "1"};
        Input input = new StubInput(answers);
        UserAction[] actions = {new FindByNameAction(out), new ExitAction()};
        new StartUI(out).init(input, tracker, actions);
        Item[] expectedArray = {item0, item1, item2};
        Assert.assertArrayEquals(expectedArray, tracker.findByName(item0.getName()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        String[] answers = {"0"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        UserAction[] actions = {new ExitAction()};
        new StartUI(out).init(input, tracker, actions);
        String expected = "Menu." + System.lineSeparator() + "0. Exit" + System.lineSeparator();
        Assert.assertEquals(expected, out.toString());
    }

}