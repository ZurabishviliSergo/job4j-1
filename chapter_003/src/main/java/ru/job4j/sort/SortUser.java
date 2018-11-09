package ru.job4j.sort;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Class description.
 *
 * @author Vladimir Mytnik (vova@mytnik.net).
 * @version 0.1.
 * @since 11/7/18
 */
public class SortUser {
    public Set<User> sort (List<User> users) {
        TreeSet<User> result;
        result = new TreeSet<>(users);
        return result;
    }
}
