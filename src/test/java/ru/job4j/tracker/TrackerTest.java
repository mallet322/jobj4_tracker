package ru.job4j.tracker;

import java.util.List;
import java.util.Random;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.is;
import org.junit.Assert;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class TrackerTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item();
        item.setName("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenTestFindById() {
        Tracker tracker = new Tracker();
        Item bug = new Item("Bug");
        Item item = tracker.add(bug);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenTestFindAll() {
        Tracker tracker = new Tracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        Item result = tracker.findAll().get(0);
        assertThat(result.getName(), is(first.getName()));
    }

    @Test
    public void whenTestFindByNameCheckArrayLength() {
        Tracker tracker = new Tracker();
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
        Tracker tracker = new Tracker();
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
        Tracker tracker = new Tracker();
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
        Tracker tracker = new Tracker();
        Item item = new Item();
        tracker.add(item);
        Assert.assertTrue(tracker.delete(item.getId()));
        Assert.assertNull(tracker.findById(item.getId()));
    }

    @Test
    public void whenNotDelete() {
        Tracker tracker = new Tracker();
        Item item = new Item();
        tracker.add(item);
        Random random = new Random();
        Assert.assertFalse(tracker.delete(random.nextInt()));
    }

}