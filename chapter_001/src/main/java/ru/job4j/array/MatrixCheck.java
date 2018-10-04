package ru.job4j.array;

public class MatrixCheck {
    public boolean mono(boolean[][] data) {
        boolean result = true;
        int size = data[0].length;
        boolean firstDiagonalFlag = data[0][0];
        boolean secondDiagonalFlag = data[0][size - 1];
        for (int i = 1; i < size; i++) {
            if ((data[i][i] != firstDiagonalFlag) || (data[i][size - i -1] != secondDiagonalFlag)) {
                result = false;
                break;
            }
        }
        return result;
    }
}