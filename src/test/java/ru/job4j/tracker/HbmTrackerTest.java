package ru.job4j.tracker;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.store.impl.HbmTracker;

public class HbmTrackerTest {

    private HbmTracker tracker;

    @Before
    public void setUp() {
        tracker = new HbmTracker();
        tracker.init();
    }

    @Test
    public void whenCreateAndReplaceItem() {
        tracker.add(new Item("some-item"));
        Item expected = new Item("some-item-1");
        Assert.assertTrue(tracker.replace(1, expected));
        Item actual = tracker.findById(1);
        Assert.assertEquals(expected.getName(), actual.getName());
        Assert.assertEquals(expected.getDescription(), actual.getDescription());
    }

    @Test
    public void whenCreateAndDeleteItem() {
        Item expected = new Item("some-item-1");
        tracker.add(expected);
        Assert.assertEquals(1, tracker.findAll().size());
        Assert.assertTrue(tracker.delete(1));
        Assert.assertEquals(0, tracker.findAll().size());
    }

    @Test
    public void whenCreateItemAndGetOneRowById() {
        Item expected = new Item("some-item");
        tracker.add(expected);
        Item actual = tracker.findById(1);
        Assert.assertEquals(expected.getName(), actual.getName());
    }

    @Test
    public void whenCreateItemsAndGetTwoRowsByName() {
        Item expected1 = new Item("some-item");
        Item expected2 = new Item("some-item");
        tracker.add(expected1);
        tracker.add(expected2);
        List<Item> actual = tracker.findByName("some-item");
        Assert.assertEquals(2, actual.size());
        Assert.assertEquals(expected1.getName(), actual.get(0).getName());
        Assert.assertEquals(expected2.getName(), actual.get(1).getName());
    }

    @Test
    public void whenCreateItemsAndGetAllRows() {
        Item item1 = new Item("some-item");
        Item item2 = new Item("some-item");
        Item item3 = new Item("some-item");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        List<Item> actual = tracker.findAll();
        Assert.assertEquals(3, actual.size());
        Assert.assertEquals(item1.getName(), actual.get(0).getName());
        Assert.assertEquals(item2.getName(), actual.get(1).getName());
        Assert.assertEquals(item3.getName(), actual.get(1).getName());
    }

}