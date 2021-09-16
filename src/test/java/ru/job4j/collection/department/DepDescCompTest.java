package ru.job4j.collection.department;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class DepDescCompTest {

    @Test
    public void compare() {
        int rsl = new DepDescComp().compare(
                "K2/SK1/SSK2",
                "K2/SK1/SSK1"
        );
        Assert.assertThat(rsl, Matchers.greaterThan(0));
    }

    @Test
    public void whenUpDepartmentGoBefore() {
        int rsl = new DepDescComp().compare(
                "K2",
                "K2/SK1"
        );
        Assert.assertThat(rsl, Matchers.lessThan(0));
    }

    @Test
    public void sortDepartmentsDesc() {
        List<String> expected = Arrays.asList(
                "K2",
                "K2/SK1",
                "K2/SK1/SSK1",
                "K2/SK1/SSK2",
                "K2/SK2",
                "K2/SK2/SSK1",
                "K1",
                "K1/SK1",
                "K1/SK1/SSK1",
                "K1/SK1/SSK2",
                "K1/SK2");
        List<String> actual = Arrays.asList(
                "K2/SK2/SSK1",
                "K2/SK2",
                "K2/SK1/SSK2",
                "K2",
                "K1/SK1",
                "K2/SK1/SSK1",
                "K1/SK2",
                "K2/SK1",
                "K1/SK1/SSK1",
                "K1/SK1/SSK2",
                "K1"
        );
        actual.sort(new DepDescComp());
        Assert.assertThat(actual, Matchers.is(expected));
    }

}