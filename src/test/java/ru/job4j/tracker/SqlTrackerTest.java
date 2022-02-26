package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class SqlTrackerTest {

    private static Connection connection;

    @BeforeClass
    public static void initConnection() {
        try (InputStream in = SqlTrackerTest.class.getClassLoader()
                                                  .getResourceAsStream("test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
            connection.prepareStatement(
                    "CREATE TABLE IF NOT EXISTS items(\n"
                            + "id serial primary key,"
                            + "name text,"
                            + "description text,"
                            + "created timestamp\n"
                            + ");"
            ).executeUpdate();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterClass
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @After
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        Assert.assertThat(tracker.findById(item.getId()), Matchers.is(item));
    }

    @Test
    public void whenSaveItemAndEditHim() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        item.setName("New item");
        Assert.assertTrue(tracker.replace(item.getId(), item));
        Item newItem = tracker.findById(item.getId());
        Assert.assertEquals(item.getName(), newItem.getName());
    }

    @Test
    public void whenDeleteItem() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        tracker.delete(item.getId());
        Assert.assertNull(tracker.findById(item.getId()));
    }

    @Test
    public void whenGetItemById() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        Assert.assertEquals(item, tracker.findById(item.getId()));
    }

    @Test
    public void whenGetItemsByName() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item0 = new Item("item");
        Item item1 = new Item("item");
        Item item2 = new Item("item");
        tracker.add(item0);
        tracker.add(item1);
        tracker.add(item2);
        var items = tracker.findByName(item0.getName());
        Assert.assertEquals(3, items.size());
        Assert.assertEquals(item1.getName(), items.get(1).getName());
    }

    @Test
    public void whenGetAllItems() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item0 = new Item("item");
        Item item1 = new Item("item1");
        Item item2 = new Item("item2");
        Item item3 = new Item("item2");
        tracker.add(item0);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        var items = tracker.findAll();
        Assert.assertEquals(4, items.size());
        Assert.assertEquals(item2.getName(), items.get(2).getName());
    }

}