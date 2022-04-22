package ru.job4j.tracker;

import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import ru.job4j.tracker.action.impl.CreateAction;
import ru.job4j.tracker.action.impl.DeleteAction;
import ru.job4j.tracker.action.impl.ExitAction;
import ru.job4j.tracker.action.impl.FindByIdAction;
import ru.job4j.tracker.action.impl.FindByNameAction;
import ru.job4j.tracker.action.impl.ReplaceAction;
import ru.job4j.tracker.action.UserAction;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.impl.StubInput;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;
import ru.job4j.tracker.store.impl.MemTracker;

public class StartUITest {

    @Test
    public void whenAddItem() {
        Output out = new StubOutput();
        String[] answers = {"0", "Some Item", "1"};
        Input input = new StubInput(answers);
        MemTracker tracker = new MemTracker();
        List<UserAction> actions = List.of(new CreateAction(out), new ExitAction(out));
        new StartUI(out).init(input, tracker, actions);
        Item actual = tracker.findAll().get(0);
        Item expected = new Item("Some Item");
        Assert.assertEquals(expected.getName(), actual.getName());
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
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
        MemTracker tracker = new MemTracker();
        Item item = new Item(1, "Some Item");
        tracker.add(item);
        String[] answers = {"0", String.valueOf(item.getId()), "1"};
        Input input = new StubInput(answers);
        List<UserAction> actions = List.of(new DeleteAction(out), new ExitAction(out));
        new StartUI(out).init(input, tracker, actions);
        Assert.assertNull(tracker.findById(item.getId()));
    }

    @Test
    public void whenFindItemById() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item(1, "Some Item");
        tracker.add(item);
        String[] answers = {"0", String.valueOf(item.getId()), "1"};
        Input input = new StubInput(answers);
        List<UserAction> actions = List.of(new FindByIdAction(out), new ExitAction(out));
        new StartUI(out).init(input, tracker, actions);
        String ln = System.lineSeparator();
        String actual =
                "Menu.".concat(ln)
                       .concat("0. Find item by id").concat(ln)
                       .concat("1. Exit").concat(ln)
                       .concat("=== Find item by id ===").concat(ln)
                       .concat(item.toString()).concat(ln)
                       .concat("Menu.").concat(ln)
                       .concat("0. Find item by id").concat(ln)
                       .concat("1. Exit").concat(ln)
                       .concat("=== Exit ===").concat(ln);
        Assert.assertThat(out.toString(), Matchers.is(actual));
    }

    @Test
    public void whenFindItemsByName() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
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
                "Menu.".concat(ln)
                       .concat("0. Find items by name").concat(ln)
                       .concat("1. Exit").concat(ln)
                       .concat("=== Find items by name ===").concat(ln)
                       .concat(item0.toString()).concat(ln)
                       .concat(item1.toString()).concat(ln)
                       .concat(item2.toString()).concat(ln)
                       .concat("Menu.").concat(ln)
                       .concat("0. Find items by name").concat(ln)
                       .concat("1. Exit").concat(ln)
                       .concat("=== Exit ===").concat(ln);
        Assert.assertThat(out.toString(), Matchers.is(actual));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        String[] answers = {"0"};
        Input input = new StubInput(answers);
        MemTracker tracker = new MemTracker();
        List<UserAction> actions = List.of(new ExitAction(out));
        new StartUI(out).init(input, tracker, actions);
        String ln = System.lineSeparator();
        String actual = "Menu.".concat(ln)
                               .concat("0. Exit").concat(ln)
                               .concat("=== Exit ===").concat(ln);
        Assert.assertThat(out.toString(), Matchers.is(actual));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        String[] answers = {"1", "0"};
        Input input = new StubInput(answers);
        MemTracker tracker = new MemTracker();
        List<UserAction> actions = List.of(new ExitAction(out));
        new StartUI(out).init(input, tracker, actions);
        String ln = System.lineSeparator();
        String actual = "Menu.".concat(ln)
                               .concat("0. Exit").concat(ln)
                               .concat("Wrong input, you can select: 0 .. 0").concat(ln)
                               .concat("Menu.").concat(ln)
                               .concat("0. Exit").concat(ln)
                               .concat("=== Exit ===").concat(ln);
        Assert.assertThat(out.toString(), Matchers.is(actual));
    }

}