package ru.job4j.stream;

import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class ArrayListFilterTest {

    @Test
    public void whenFilterNegativeNumbersThenReturnPositiveNumbers() {
        List<Integer> expected = List.of(1, -10, 2, -23131, -121, 3, -5);
        List<Integer> actual = List.of(1, 2, 3);
        Assert.assertThat(ArrayListFilter.filterNegativeNumbers(expected), Matchers.is(actual));
    }

    @Test
    public void whenListContainsAllPositiveNumbersThenReturnPositiveNumbers() {
        List<Integer> expected = List.of(1, 2, 3, 4, 5);
        List<Integer> actual = List.of(1, 2, 3, 4, 5);
        Assert.assertThat(ArrayListFilter.filterNegativeNumbers(expected), Matchers.is(actual));
    }

    @Test
    public void whenListContainsAllNegativeNumbersThenReturnEmptyList() {
        List<Integer> expected = List.of(-1, -10, -2, -23131, -121, -3, -5);
        List<Integer> actual = List.of(1, 2, 3);
        Assert.assertThat(ArrayListFilter.filterNegativeNumbers(expected), Matchers.empty());
    }

}