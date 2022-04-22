package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import ru.job4j.tracker.action.impl.DeleteAction;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;
import ru.job4j.tracker.store.impl.MemTracker;

public class DeleteActionTest {

    @Test
    public void whenDeleteItemWithMockInputObject() {
        Input input = Mockito.mock(Input.class);
        Mockito.when(input.askInt(Mockito.anyString())).thenReturn(1);
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();

        tracker.add(new Item("Some item"));
        Assert.assertEquals(1, tracker.findAll().size());

        DeleteAction action = new DeleteAction(out);
        action.execute(input, tracker);

        String ln = System.lineSeparator();
        Assert.assertEquals("=== Delete item ====" + ln + "Заявка удалена успешно." + ln,
                            out.toString());
        Assert.assertEquals(0, tracker.findAll().size());
    }

}