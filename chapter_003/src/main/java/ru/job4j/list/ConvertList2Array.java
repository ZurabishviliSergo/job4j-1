package ru.job4j.list;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Class description.
 *
 * @author Vladimir Mytnik (vova@mytnik.net).
 * @version 0.1.
 * @since 11/6/18
 */
// Как можно переписать на стримы этот метод? Несколько дней провозился, но так и не смог.
public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        final int cells = list.size() % rows == 0 ? list.size() / rows : list.size() / rows + 1;
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
//        ArrayList<int[]> s1 = list.stream().reduce(new ArrayList<>(), (acc, el) -> {
//            acc.add(el);
//        }, (x, y) -> {
//            x.add(y);
//            return y;
//        });
//        System.out.println(s1.size());
//        for (int[] el: s1) {
//            for (int el2: el) {
//                System.out.println(el2);
//            }
//            System.out.println();
//        }
//        Stream<Integer> s1 = list.stream();
//        Stream<int[]> s2 = s1.reduce(IntStream.empty(), el -> {
//
//        });
//        return new int[][]{};
    }
    public List<Integer> convert(List<int[]> list) {
        IntStream stream = list.stream().flatMapToInt(Arrays::stream);
        return stream.boxed().collect(Collectors.toList());
    }
}
