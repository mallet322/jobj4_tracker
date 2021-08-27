package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

public class MaxTest {

    @Test
    public void maxOf2() {
        int a = 1;
        int b = 2;
        int expected = 2;
        int actual = Max.max(a, b);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void maxOf3() {
        int a = 1;
        int b = 2;
        int c = 3;
        int expected = 3;
        int actual = Max.max(a, b, c);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void maxOf4() {
        int a = 1;
        int b = 2;
        int c = 3;
        int d = 4;
        int expected = 4;
        int actual = Max.max(a, b, c, d);
        Assert.assertEquals(expected, actual);
    }

}