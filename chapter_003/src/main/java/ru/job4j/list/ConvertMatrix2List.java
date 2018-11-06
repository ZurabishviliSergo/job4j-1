package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Class description.
 *
 * @author Vladimir Mytnik (vova@mytnik.net).
 * @version 0.1.
 * @since 11/6/18
 */

public class ConvertMatrix2List {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] outerArr : array) {
            for (int item : outerArr) {
                list.add(item);
            }
        }
        return list;
    }

}