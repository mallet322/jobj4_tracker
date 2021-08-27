package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    @Test
    public void whenDistance00And01Then1() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 1);
        double expected = 1.0;
        double actual = a.distance(b);
        Assert.assertEquals(expected, actual, 0.001);
    }

    @Test
    public void whenDistance00And02Then2() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        double expected = 2.0;
        double actual = a.distance(b);
        Assert.assertEquals(expected, actual, 0.001);
    }

    @Test
    public void whenDistance00And03Then3() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 3);
        double expected = 3.0;
        double actual = a.distance(b);
        Assert.assertEquals(expected, actual, 0.001);
    }

    @Test
    public void whenDistance000And001Then1() {
        Point a = new Point(0, 0, 0);
        Point b = new Point(0, 0, 1);
        double expected = 1.0;
        double actual = a.distance3d(b);
        Assert.assertEquals(expected, actual, 0.001);
    }

    @Test
    public void whenDistance000And002Then2() {
        Point a = new Point(0, 0, 0);
        Point b = new Point(0, 0, 2);
        double expected = 2.0;
        double actual = a.distance3d(b);
        Assert.assertEquals(expected, actual, 0.001);
    }

    @Test
    public void whenDistance000And003Then3() {
        Point a = new Point(0, 0, 0);
        Point b = new Point(0, 0, 3);
        double expected = 3.0;
        double actual = a.distance3d(b);
        Assert.assertEquals(expected, actual, 0.001);
    }

}