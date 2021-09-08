package ru.job4j.collection;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvertListTest {

    @Test
    public void whenTwoList() {
        List<int[]> in = new ArrayList<>();
        in.add(new int[] {1});
        in.add(new int[] {2, 3});
        List<Integer> expect = Arrays.asList(1, 2, 3);
        Assert.assertThat(ConvertList.convert(in), Matchers.is(expect));
    }

    @Test
    public void whenThreeList() {
        List<int[]> in = new ArrayList<>();
        in.add(new int[] {1});
        in.add(new int[] {2, 3});
        in.add(new int[] {4, 5, 6});
        List<Integer> expect = Arrays.asList(1, 2, 3, 4, 5, 6);
        Assert.assertThat(ConvertList.convert(in), Matchers.is(expect));
    }

    @Test
    public void whenFourList() {
        List<int[]> in = new ArrayList<>();
        in.add(new int[] {1});
        in.add(new int[] {2, 3});
        in.add(new int[] {4, 5, 6});
        in.add(new int[] {7, 8, 9, 10});
        List<Integer> expect = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Assert.assertThat(ConvertList.convert(in), Matchers.is(expect));
    }

}