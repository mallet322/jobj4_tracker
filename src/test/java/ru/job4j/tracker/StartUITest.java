package ru.job4j.tracker;

import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class StartUITest {

    @Test
    public void whenAddItem() {
        Output out = new StubOutput();
        String[] answers = {"0", "Some Item", "1"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        List<UserAction> actions = List.of(new CreateAction(out), new ExitAction(out));
        new StartUI(out).init(input, tracker, actions);
        Item actual = tracker.findAll().get(0);
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
        List<UserAction> actions = List.of(new ReplaceAction(out), new ExitAction(out));
        new StartUI(out).init(input, tracker, actions);
        Item expected = new Item("Replaced Item");
        Item actual = tracker.findAll().get(0);
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
        List<UserAction> actions = List.of(new DeleteAction(out), new ExitAction(out));
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
        List<UserAction> actions = List.of(new FindAllAction(out), new ExitAction(out));
        new StartUI(out).init(input, tracker, actions);
        String ln = System.lineSeparator();
        String actual =
                "Menu." + ln
                + "0. Show all items"+ ln
                + "1. Exit" + ln
                + "=== Show all items ===" + ln
                + item + ln
                + "Menu." + ln
                + "0. Show all items" + ln
                + "1. Exit" + ln
                + "=== Exit ===" + ln;
        Assert.assertThat(out.toString(), Matchers.is(actual));

    }

    @Test
    public void whenFindItemById() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = new Item(1, "Some Item");
        tracker.add(item);
        String[] answers = {"0", String.valueOf(item.getId()), "1"};
        Input input = new StubInput(answers);
        List<UserAction> actions = List.of(new FindByIdAction(out), new ExitAction(out));
        new StartUI(out).init(input, tracker, actions);
        String ln = System.lineSeparator();
        String actual =
                "Menu." + ln
                + "0. Find item by id"+ ln
                + "1. Exit" + ln
                + "=== Find item by id ===" + ln
                + item + ln
                + "Menu." + ln
                + "0. Find item by id" + ln
                + "1. Exit" + ln
                + "=== Exit ===" + ln;
        Assert.assertThat(out.toString(), Matchers.is(actual));
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
        List<UserAction> actions = List.of(new FindByNameAction(out), new ExitAction(out));
        new StartUI(out).init(input, tracker, actions);
        String ln = System.lineSeparator();
        String actual =
                "Menu." + ln
                + "0. Find items by name"+ ln
                + "1. Exit" + ln
                + "=== Find items by name ===" + ln
                + item0 + ln
                + item1 + ln
                + item2 + ln
                + "Menu." + ln
                + "0. Find items by name" + ln
                + "1. Exit" + ln
                + "=== Exit ===" + ln;
        Assert.assertThat(out.toString(), Matchers.is(actual));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        String[] answers = {"0"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        List<UserAction> actions = List.of(new ExitAction(out));
        new StartUI(out).init(input, tracker, actions);
        String ln = System.lineSeparator();
        String actual =
                "Menu." + ln +
                "0. Exit" + ln +
                "=== Exit ===" + ln;
        Assert.assertThat(out.toString(), Matchers.is(actual));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        String[] answers = {"1", "0"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        List<UserAction> actions = List.of(new ExitAction(out));
        new StartUI(out).init(input, tracker, actions);
        String ln = System.lineSeparator();
        String actual =
                "Menu." + ln +
                "0. Exit" + ln +
                "Wrong input, you can select: 0 .. 0" + ln +
                "Menu." + ln +
                "0. Exit" + ln +
                "=== Exit ===" + ln;
        Assert.assertThat(out.toString(), Matchers.is(actual));
    }

}