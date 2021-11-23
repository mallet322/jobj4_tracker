package ru.job4j.collection.passport;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class PassportOfficeTest {

    @Test
    public void add() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        Assert.assertTrue(office.add(citizen));
        Assert.assertThat(office.get(citizen.getPassport()), Matchers.is(citizen));
    }

    @Test
    public void addDuplicate() {
        Citizen citizen0 = new Citizen("2f44a", "Petr Arsentev");
        Citizen citizen1 = new Citizen("2f44a", "Petr Arsentev");
        Assert.assertEquals(citizen0.hashCode(), citizen1.hashCode());
        PassportOffice office = new PassportOffice();
        office.add(citizen0);
        Assert.assertFalse(office.add(citizen1));
    }

}