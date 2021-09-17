package ru.job4j.lambda;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class RefMethodTest {

    @Test
    public void whenCutSurname() {
        ByteArrayInputStream in = new ByteArrayInputStream("Ivan\r\nPetr Arsen..".getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        System.setIn(in);
        List<String> names = Arrays.asList("Ivan", "Petr Arsentev");
        names.forEach(RefMethod::cutOut);
        Assert.assertThat(out.toString(), Matchers.is("Ivan\r\nPetr Arsen..\n"));
    }

}