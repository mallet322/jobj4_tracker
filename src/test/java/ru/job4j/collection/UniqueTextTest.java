package ru.job4j.collection;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class UniqueTextTest {

    @Test
    public void isEquals() {
        String origin = "My cat eats a mouse and milk";
        String text = "My cat eats milk and a mouse";
        Assert.assertThat(UniqueText.isEquals(origin, text), Matchers.is(true));
    }

    @Test
    public void isNotEquals() {
        String origin = "My cat eats a mouse";
        String text = "A mouse is eaten by a cat";
        Assert.assertThat(UniqueText.isEquals(origin, text), Matchers.is(false));
    }

}