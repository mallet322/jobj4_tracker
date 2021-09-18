package ru.job4j.stream.travelcompany;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class ProfilesTest {

    @Test
    public void collectAddressOnNewList() {
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

    @Test
    public void sortWithoutDuplicates() {
        List<Address> expected = Arrays.asList(
                new Address("Ekaterinburg", "ElcinCenter", 1, 1),
                new Address("Lipetsk", "Metallurgov", 10, 5),
                new Address("Moscow", "Red square", 1, 1),
                new Address("Saint-Petersburg", "Peterhof", 2, 10),
                new Address("Samara", "Naberejnaya", 8, 3)
        );
        List<Profile> profiles = List.of(
                new Profile(new Address("Moscow", "Red square", 1, 1)),
                new Profile(new Address("Saint-Petersburg", "Peterhof", 2, 10)),
                new Profile(new Address("Lipetsk", "Metallurgov", 10, 5)),
                new Profile(new Address("Ekaterinburg", "ElcinCenter", 1, 1)),
                new Profile(new Address("Samara", "Naberejnaya", 8, 3))
        );
        Profiles pr = new Profiles();
        List<Address> actual = pr.collect(profiles);
        Assert.assertThat(actual, Matchers.is(expected));
    }

    @Test
    public void sortWithDuplicates() {
        List<Address> expected = Arrays.asList(
                new Address("Ekaterinburg", "ElcinCenter", 1, 1),
                new Address("Lipetsk", "Metallurgov", 10, 5),
                new Address("Samara", "Naberejnaya", 8, 3)
        );
        List<Profile> profiles = List.of(
                new Profile(new Address("Ekaterinburg", "ElcinCenter", 1, 1)),
                new Profile(new Address("Samara", "Naberejnaya", 8, 3)),
                new Profile(new Address("Lipetsk", "Metallurgov", 10, 5)),
                new Profile(new Address("Ekaterinburg", "ElcinCenter", 1, 1)),
                new Profile(new Address("Samara", "Naberejnaya", 8, 3))
        );
        Profiles pr = new Profiles();
        List<Address> actual = pr.collect(profiles);
        Assert.assertThat(actual, Matchers.is(expected));
    }

}