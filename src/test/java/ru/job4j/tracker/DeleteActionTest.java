package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

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