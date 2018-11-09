package ru.job4j.sort;

import java.util.*;

/**
 * Class description.
 *
 * @author Vladimir Mytnik (vova@mytnik.net).
 * @version 0.1.
 * @since 11/7/18
 */
public class SortUser {
    public Set<User> sort (List<User> users) {
        return new TreeSet<>(users);
    }
}
