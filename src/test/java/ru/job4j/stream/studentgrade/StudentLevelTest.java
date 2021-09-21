package ru.job4j.stream.studentgrade;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class StudentLevelTest {

    @Test
    public void whenSorted() {
        List<Student> input = new ArrayList<>();
        input.add(new Student("Masha", 28));
        input.add(new Student("Pety", 128));
        List<Student> expected = List.of(
                new Student("Pety", 128),
                new Student("Masha", 28)
        );
        Assert.assertThat(StudentLevel.levelOf(input, 20), Matchers.is(expected));
    }

    @Test
    public void whenFilter10StudentsThenReturn5() {
        List<Student> input = new ArrayList<>();
        input.add(new Student("Masha", 28));
        input.add(new Student("Pety", 128));
        input.add(new Student("Mike", 100));
        input.add(new Student("Simon", 99));
        input.add(new Student("Cody", 101));
        input.add(new Student("Fisher", 1));
        input.add(new Student("Jack", 2));
        input.add(new Student("Andy", 1000));
        input.add(new Student("Sonya", 103));
        input.add(new Student("Elias", 100000));
        List<Student> expected = List.of(
                new Student("Elias", 100000),
                new Student("Andy", 1000),
                new Student("Pety", 128),
                new Student("Sonya", 103),
                new Student("Cody", 101)
        );
        Assert.assertThat(StudentLevel.levelOf(input, 100), Matchers.is(expected));
    }

    @Test
    public void whenOnlyNull() {
        List<Student> input = new ArrayList<>();
        input.add(null);
        List<Student> expected = List.of();
        Assert.assertThat(StudentLevel.levelOf(input, 100), Matchers.is(expected));
    }

    @Test
    public void whenHasNull() {
        List<Student> input = new ArrayList<>();
        input.add(null);
        input.add(new Student("Pety", 28));
        List<Student> expected = List.of(new Student("Pety", 28));
        Assert.assertThat(StudentLevel.levelOf(input, 10), Matchers.is(expected));
    }

}