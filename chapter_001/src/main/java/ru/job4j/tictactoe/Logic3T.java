package ru.job4j.tictactoe;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean isWinnerX() {
//        boolean result = true;
//        int size = this.table[0].length;
//        for (int i = 0; i < size; i++) {
//            if ((!table[i][i].hasMarkX() || !table[i][size - i - 1].hasMarkX()) || ) {
//                result = false;
//                break;
//            }
//        }
//        return result;
        return false;
    }

    public boolean isWinnerO() {
        return false;
    }

    public boolean hasGap() {
        boolean result = false;
        for (int i = 0; i < this.table[0].length; i++) {
            for (int j = 0; j < this.table[0].length; j++) {
                if (!(table[i][j].hasMarkX() || table[i][j].hasMarkO())) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
}
