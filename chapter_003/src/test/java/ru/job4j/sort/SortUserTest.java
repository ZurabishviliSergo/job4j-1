package ru.job4j.sort;

import org.junit.Test;

import java.util.Set;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class description.
 *
 * @author Vladimir Mytnik (vova@mytnik.net).
 * @version 0.1.
 * @since 11/7/18
 */
public class SortUserTest {
    @Test
    public void whenSet4UsersThen3() {
        SortUser su = new SortUser();
        List<User> usersList = List.of(
                new User("Vasya", 40),
                new User("Petya", 20),
                new User("Vasya", 40)
        );
        Set<User> tree = su.sort(usersList);
        assertThat(tree.size(), is(2));
    }
    @Test
    public void whenSet4UsersThenSortByAge() {
        SortUser su = new SortUser();
        List<User> usersList = List.of(
                new User("Vasya", 40),
                new User("Petya", 30),
                new User("Vova", 20),
                new User("Vasya", 50)
        );
        Set<User> tree = su.sort(usersList);
        User[] arrFromTree = new User[tree.size()];
        tree.toArray(arrFromTree);
        assertThat(arrFromTree[0].getName(), is("Vova"));
    }
    @Test
    public void whenSortByNameLength() {
        SortUser su = new SortUser();
        List<User> usersList = List.of(
                new User("Vasya", 40),
                new User("V", 50),
                new User("Vas", 20)
        );
        List<User> list = su.sortNameLength(usersList);
        assertThat(list.get(0).getName(), is("V"));
    }
    @Test
    public void whenSortByAllFields() {
        SortUser su = new SortUser();
        List<User> usersList = List.of(
                new User("Vova", 5),
                new User("Vova", 30),
                new User("Anya", 10),
                new User("Anya", 20)
        );
        List<User> list = su.sortByAllFields(usersList);
        assertThat(list.get(0).getAge(), is(10));
    }
}
