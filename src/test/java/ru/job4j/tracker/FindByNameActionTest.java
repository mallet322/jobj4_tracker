package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import ru.job4j.tracker.action.impl.FindByNameAction;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;
import ru.job4j.tracker.store.impl.MemTracker;

public class FindByNameActionTest {

    @Test
    public void whenAddOneItemThenGetOneItem() {
        Input input = Mockito.mock(Input.class);
        Mockito.when(input.askStr(Mockito.anyString())).thenReturn("Some item");

        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();

        Item item = new Item("Some item");
        tracker.add(item);

        FindByNameAction action = new FindByNameAction(out);
        action.execute(input, tracker);

        Item actualItem = tracker.findAll().get(0);

        Assert.assertEquals(item.getName(), actualItem.getName());
        Assert.assertEquals(1, tracker.findAll().size());
    }

}