package ru.job4j.lambda;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class CustomComparatorTest {

    @Test
    public void lexicographicSort() {
        List<String> expected = Arrays.asList("weqas", "bcd", "abc", "aaqwerty", "perona");
        List<String> actual = Arrays.asList("aaqwerty", "abc", "bcd", "perona", "weqas");
        CustomComparator.stringComparator(expected);
        Assert.assertThat(expected, Matchers.is(actual));
    }

    @Test
    public void lengthDescSort() {
        List<String> expected = Arrays.asList("w", "bc", "abc", "aaqwertyqweqe", "perona");
        List<String> actual = Arrays.asList("aaqwertyqweqe", "perona", "abc", "bc", "w");
        CustomComparator.stringLengthDescComparator(expected);
        Assert.assertThat(expected, Matchers.is(actual));
    }

}