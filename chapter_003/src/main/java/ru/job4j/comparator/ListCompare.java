package ru.job4j.comparator;

import java.util.Comparator;

/**
 * Class description.
 *
 * @author Vladimir Mytnik (vova@mytnik.net).
 * @version 0.1.
 * @since 11/9/18
 */
public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = 0;
        int size = left.length() > right.length() ? right.length() : left.length();
        for (int i = 0; i < size; i++) {
            result = Character.compare(left.charAt(i), right.charAt(i));
            if (result != 0) {
                break;
            }
        }
        if (result == 0 && left.length() != right.length()) {
            result = left.length() > right.length() ? 1 : -1;
        }
        return result;
    }
}
