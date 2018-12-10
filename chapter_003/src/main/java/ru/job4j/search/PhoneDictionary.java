package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Phone dictionary with persons.
 *
 * @author Vladimir Mytnik (vova@mytnik.net).
 * @version 0.1.
 * @since 11/5/18
 */
public class PhoneDictionary {
    /**
     * All persons Array.
     */
    private List<Person> persons = new ArrayList<>();
    /**
     * Add new person to dictionary.
     * @param person - new person.
     */
    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Find all users array with key in any field.
     * @param key search key.
     * @return matching users list.
     */
    public List<Person> find(String key) {
//        List<Person> result = new ArrayList<>();
//        for (Person person: this.persons) {
//            if (person.getName().contains(key) || person.getSurname().contains(key)
//                    || person.getAddress().contains(key) || person.getPhone().contains(key)) {
//                result.add(person);
//            }
//        }
//        return result;
        var stream = this.persons.stream();
        return stream.filter(person -> person.getName().contains(key)
                || person.getSurname().contains(key) || person.getAddress().contains(key)
                || person.getPhone().contains(key)).collect(Collectors.toList());
    }
}