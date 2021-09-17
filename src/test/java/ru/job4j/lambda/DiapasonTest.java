package ru.job4j.lambda;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class DiapasonTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = Diapason.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        Assert.assertThat(result, Matchers.is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        List<Double> result = Diapason.diapason(5, 8, x -> x * x);
        List<Double> expected = Arrays.asList(25D, 36D, 49D);
        Assert.assertThat(result, Matchers.is(expected));
    }

    @Test
    public void whenExponentialFunctionOn2ThenExponentialResult() {
        List<Double> result = Diapason.diapason(5, 8, x -> Math.pow(2.0, x));
        List<Double> expected = Arrays.asList(32D, 64D, 128D);
        Assert.assertThat(result, Matchers.is(expected));
    }

}