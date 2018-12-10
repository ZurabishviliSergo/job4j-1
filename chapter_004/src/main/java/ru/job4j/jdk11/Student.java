package ru.job4j.jdk11;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Class description.
 *
 * @author Vladimir Mytnik (vova@mytnik.net).
 * @version 0.1.
 * @since 12/10/18
 */
public class Student implements Comparable<Student> {
    private String name;
    private int scope;

    public static List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .flatMap(Stream::ofNullable)
                .sorted()
                .takeWhile(student -> student.getScope() >= bound)
                .collect(Collectors.toList());
    }

    public Student(String name, int scope) {
        this.name = name;
        this.scope = scope;
    }

    public String getName() {
        return name;
    }

    public int getScope() {
        return scope;
    }

    @Override
    public int compareTo(Student s) {
        int result = 0;
        if (s.getScope() != this.scope) {
            result = s.getScope() > this.scope ? 1 : -1;
        }
        return result;
    }
}
