package ru.job4j.tracker;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.impl.StubInput;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;
import ru.job4j.tracker.input.impl.ValidateInput;

public class ValidateInputTest {

    @Test
    public void whenCorrectInput() {
        Output output = new StubOutput();
        String[] answers = {"1"};
        Input input = new StubInput(answers);
        ValidateInput validateInput = new ValidateInput(output, input);
        int expected = validateInput.askInt("Enter menu");
        int actual = Integer.parseInt(answers[0]);
        Assert.assertThat(expected, Matchers.is(actual));
    }

    @Test
    public void whenMultipleCorrectInput() {
        Output output = new StubOutput();
        String[] answers = {"0", "1", "2"};
        Input input = new StubInput(answers);
        ValidateInput validateInput = new ValidateInput(output, input);
        int expected0 = validateInput.askInt("Enter menu");
        int expected1 = validateInput.askInt("Find items by name");
        int expected2 = validateInput.askInt("Exit");
        int actual0 = Integer.parseInt(answers[0]);
        int actual1 = Integer.parseInt(answers[1]);
        int actual2 = Integer.parseInt(answers[2]);
        Assert.assertThat(expected0, Matchers.is(actual0));
        Assert.assertThat(expected1, Matchers.is(actual1));
        Assert.assertThat(expected2, Matchers.is(actual2));
    }

    @Test
    public void whenInvalidInput() {
        Output output = new StubOutput();
        String[] answers = {"one", "1"};
        Input input = new StubInput(answers);
        ValidateInput validateInput = new ValidateInput(output, input);
        int expected = validateInput.askInt("Enter menu");
        int actual = Integer.parseInt(answers[1]);
        Assert.assertThat(expected, Matchers.is(actual));
    }

    @Test
    public void whenInputNegativeNumber() {
        Output output = new StubOutput();
        String[] answers = {"-1"};
        Input input = new StubInput(answers);
        ValidateInput validateInput = new ValidateInput(output, input);
        int expected = validateInput.askInt("Enter menu");
        int actual = Integer.parseInt(answers[0]);
        Assert.assertThat(expected, Matchers.is(actual));
    }

}