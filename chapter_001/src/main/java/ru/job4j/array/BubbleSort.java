package ru.job4j.array;

public class BubbleSort {
    public int[] sort(int[] array) {
        int size = array.length;
        while (size >= 2) {
            for (int i = 0; i < size - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                }
            }

            size--;
        }

        return array;
    }
}
