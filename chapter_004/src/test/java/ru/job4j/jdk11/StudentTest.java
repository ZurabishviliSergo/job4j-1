package ru.job4j.jdk11;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;
/**
 * Class description.
 *
 * @author Vladimir Mytnik (vova@mytnik.net).
 * @version 0.1.
 * @since 12/10/18
 */
public class StudentTest {
    @Test
    public void whenAddSixThenGetLengthThree() {
        List<Student> list = new ArrayList<>();
        list.add(new Student("Ivan", 5));
        list.add(new Student("Fedor", 3));
        list.add(null);
        list.add(new Student("Petr", 4));
        list.add(new Student("Misha", 2));
        list.add(new Student("Anna", 5));
        assertThat(Student.levelOf(list, 4).size(), is(3));
    }
    @Test
    public void whenPetrThreeThenFirstNameIsPetr() {
        List<Student> list = new ArrayList<>();
        list.add(new Student("Ivan", 1));
        list.add(new Student("Fedor", 4));
        list.add(null);
        list.add(new Student("Petr", 5));
        list.add(new Student("Misha", 3));
        list.add(new Student("Anna", 2));
        assertThat(Student.levelOf(list, 3).get(0).getName(), is("Petr"));
    }
}
