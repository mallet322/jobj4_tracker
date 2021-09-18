package ru.job4j.stream.travelcompany;

import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class ProfilesTest {

    @Test
    public void test() {
        List<Profile> profiles = List.of(
                new Profile(new Address("Moscow", "Red square", 1, 1)),
                new Profile(new Address("Saint-Petersburg", "Peterhof", 2, 10)),
                new Profile(new Address("Lipetsk", "Metallurgov", 10, 5)),
                new Profile(new Address("Ekaterinburg", "ElcinCenter", 1, 1)),
                new Profile(new Address("Samara", "Naberejnaya", 8, 3))
        );
        Profiles pr = new Profiles();
        List<Address> addresses = pr.collect(profiles);
        profiles.forEach(profile -> Assert.assertTrue(addresses.contains(profile.getAddress())));
    }
}