package ru.job4j.stream;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class MatrixTest {

    @Test
    public void whenMatrixCollectToList() {
        Integer[][] expected = {{1, 2, 3}, {4, 5, 6}};
        List<Integer> actual = Matrix.convertMatrixToList(expected);
        Assert.assertNotNull(actual);
        Assert.assertEquals(expected[0][2], actual.get(2));
        Assert.assertEquals(expected[1][2], actual.get(5));
    }

}