package ru.job4j.coffee;

import java.util.Arrays;

public class Machine {
    private final static int[] nominals = {1, 2, 5, 10};
    private final static int price = 35;

    public int[] makeChange(int note) {
        int[] result = new int[498];
        int position = 0;
        int allChange = note - price;
        for(int i = nominals.length - 1; i >= 0;) {
            if (nominals[i] <= allChange) {
                result[position] = nominals[i];
                position++;
                allChange -= nominals[i];
            } else {
                i--;
            }
        }

        return Arrays.copyOf(result, position);
    }
}
