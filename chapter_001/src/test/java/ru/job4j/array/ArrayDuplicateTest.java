package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Tests for ArrayDuplicate class.
 *
 * @author Vladimir Mytnik (vova@mytnik.net)
 * @version 0.1
 */
public class ArrayDuplicateTest {
    /**
     * Test main remove method.
     */
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate ad = new ArrayDuplicate();
        String[] arr = {"Привет", "Мир", "Привет", "Супер", "Мир"};
        String[] result = ad.remove(arr);
        String[] expected = {"Супер", "Мир", "Привет"};
        assertThat(result, is(expected));
    }
}