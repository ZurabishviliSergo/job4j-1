package ru.job4j.coffee;

import java.util.Arrays;

public class Machine {
    private final static int[] DEN = {1, 2, 5, 10};
    private final static int PRICE = 35;

    public int[] makeChange(int note) {
        int[] result = new int[498];
        int position = 0;
        int allChange = note - PRICE;
        for (int i = DEN.length - 1; i >= 0;) {
            if (DEN[i] <= allChange) {
                result[position] = DEN[i];
                position++;
                allChange -= DEN[i];
            } else {
                i--;
            }
        }

        return Arrays.copyOf(result, position);
    }
}
