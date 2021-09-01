package ru.job4j.ex;

import org.junit.Assert;
import org.junit.Test;

public class FactTest {

    @Test
    public void whenFactorial5Then120() {
        Fact fact = new Fact();
        int n = 5;
        int expected = 120;
        int actual = fact.calc(n);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenFactorialNegativeNumberThenThrowException() {
        Fact fact = new Fact();
        int n = -5;
        fact.calc(n);
    }

}