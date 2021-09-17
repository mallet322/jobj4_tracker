package ru.job4j.lambda.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {

    private final ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> namePredicate = person -> key.equals(person.getName());
        Predicate<Person> surnamePredicate = person -> key.equals(person.getSurname());
        Predicate<Person> phonePredicate = person -> key.equals(person.getPhone());
        Predicate<Person> addressPredicate = person -> key.equals(person.getAddress());
        Predicate<Person> combine = namePredicate.or(surnamePredicate)
                                                 .or(phonePredicate)
                                                 .or(addressPredicate);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }

}
