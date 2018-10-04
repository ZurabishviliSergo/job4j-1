package ru.job4j.array;

public class MatrixCheck {
    public boolean mono(boolean[][] data) {
        boolean result = true;
        int size = data[0].length;
        boolean firstDiagonalFlag = data[0][0];
        boolean secondDiagonalFlag = data[0][size - 1];
        for (int i = 1; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if ((i == j && firstDiagonalFlag != data[i][j]) || (i + j == size - 1 && secondDiagonalFlag != data[i][j]) ) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }
}