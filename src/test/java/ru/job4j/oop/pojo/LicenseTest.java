package ru.job4j.oop.pojo;

import static org.hamcrest.Matchers.is;
import org.junit.Assert;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class LicenseTest {

    @Test
    public void eqName() {
        License first = new License();
        first.setCode("audio");
        License second = new License();
        second.setCode("audio");
        assertThat(first, is(second));
    }

    @Test
    public void eq() {
        License first = new License();
        first.setOwner("owner");
        first.setModel("model");
        first.setCode("audio");
        License second = new License();
        second.setOwner("owner");
        second.setModel("model");
        second.setCode("audio");
        Assert.assertEquals(first, second);
    }

    @Test
    public void notEq() {
        License first = new License();
        first.setOwner("owner");
        first.setModel("model");
        first.setCode("audio");
        License second = new License();
        second.setOwner("owner");
        second.setModel("model");
        second.setCode("audio1");
        Assert.assertNotEquals(first, second);
    }

}