package ru.job4j.array;

import java.util.Arrays;

/**
 * Remove duplicates from Strings array.
 *
 * @author Vladimir Mytnik(vova@mytnik.net)
 * @version 0.1
 */
public class ArrayDuplicate {
    /**
     * Main method for remove duplicates.
     * @param array strings array for processing.
     * @return array without duplicates.
     */
    public String[] remove(String[] array) {
        int size = array.length;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j <= size - 1; j++) {
                if (array[i].equals(array[j])) {
                    String tmp = array[i];
                    array[i] = array[size - 1];
                    array[size - 1] = tmp;
                    size--;
                    i--;
                    break;
                }
            }
        }

        return Arrays.copyOf(array, size);
    }
}
