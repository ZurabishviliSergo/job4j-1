package ru.job4j.sort;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Class description.
 *
 * @author Vladimir Mytnik (vova@mytnik.net).
 * @version 0.1.
 * @since 11/7/18
 */
public class SortUser {
    public Set<User> sort(List<User> users) {
        return new TreeSet<>(users);
    }
    public List<User> sortNameLength(List<User> users) {
//        Collections.sort(users, Comparator.comparingInt(o -> o.getName().length()));
//        return users;
        return users.stream().sorted(Comparator.comparingInt(o -> o.getName().length())).collect(Collectors.toList());
    }
    public List<User> sortByAllFields(List<User> users) {
//        Collections.sort(users, Comparator.comparing(User::getName).thenComparingInt(User::getAge));
//        return users;
        return users.stream().sorted(Comparator.comparing(User::getName).thenComparingInt(User::getAge))
                .collect(Collectors.toList());
    }
}
