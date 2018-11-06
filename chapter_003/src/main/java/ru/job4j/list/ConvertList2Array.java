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
public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = list.size() / rows;
        if (cells % rows != 0) { cells++; }
        int position = 0;
        int[][] array = new int[rows][cells];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cells; j++) {
                if (position < list.size()) {
                    array[i][j] = list.get(position++);
                }
            }
        }
        return array;
    }

    public List<Integer> convert (List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        for (int[] arr : list) {
            for (int item : arr) {
                result.add(item);
            }
        }
        return result;
    }
}