package ru.job4j.tracker;

import java.util.List;
import java.util.Random;

import static org.hamcrest.Matchers.is;
import org.junit.Assert;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class TrackerTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        MemTracker tracker = new MemTracker();
        Item item = new Item();
        item.setName("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenTestFindById() {
        MemTracker tracker = new MemTracker();
        Item bug = new Item("Bug");
        Item item = tracker.add(bug);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenTestFindAll() {
        MemTracker tracker = new MemTracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        Item result = tracker.findAll().get(0);
        assertThat(result.getName(), is(first.getName()));
    }

    @Test
    public void whenTestFindByNameCheckArrayLength() {
        MemTracker tracker = new MemTracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        tracker.add(new Item("First"));
        tracker.add(new Item("Second"));
        tracker.add(new Item("First"));
        List<Item> result = tracker.findByName(first.getName());
        assertThat(result.size(), is(3));
    }

    @Test
    public void whenTestFindByNameCheckSecondItemName() {
        MemTracker tracker = new MemTracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        tracker.add(new Item("First"));
        tracker.add(new Item("Second"));
        tracker.add(new Item("First"));
        List<Item> result = tracker.findByName(second.getName());
        assertThat(result.get(1).getName(), is(second.getName()));
    }

    @Test
    public void whenReplace() {
        MemTracker tracker = new MemTracker();
        Item itemBeforeUpdate = new Item("Item before update");
        tracker.add(itemBeforeUpdate);
        Item itemAfterUpdate = new Item("Item after update");
        Assert.assertTrue(tracker.replace(itemBeforeUpdate.getId(), itemAfterUpdate));
        String expected = itemAfterUpdate.getName();
        String actual = tracker.findById(itemBeforeUpdate.getId()).getName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void whenDelete() {
        MemTracker tracker = new MemTracker();
        Item item = new Item();
        tracker.add(item);
        Assert.assertTrue(tracker.delete(item.getId()));
        Assert.assertNull(tracker.findById(item.getId()));
    }

    @Test
    public void whenNotDelete() {
        MemTracker tracker = new MemTracker();
        Item item = new Item();
        tracker.add(item);
        Random random = new Random();
        Assert.assertFalse(tracker.delete(random.nextInt()));
    }

}