package ru.job4j.tictactoe;

/**
 * Checking if win X, O or all area is filled.
 * @author Vladimir Mytnik (vova@mytnik.net)
 * @version 0.1
 */
public class Logic3T {
    /**
     * Playing area.
     */
    private final Figure3T[][] table;

    /**
     * Constructor - set the new play area.
     * @param table new play area.
     */
    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    /**
     * Check horizontal fields for winner.
     * @param idx line index.
     * @param figure  - 1 if X and any another number if O.
     * @return true if all fields in line marked as true.
     */
    private boolean checkHorizontal(int idx, int figure) {
        boolean result = true;
        for (int i = 0; i < table.length; i++) {
            boolean figureMark = figure == 1 ? this.table[idx][i].hasMarkX() : this.table[idx][i].hasMarkO();
            if (!figureMark) {
                result = false;
                break;
            }
        }
        return result;
    }
    /**
     * Check vertical fields for winner.
     * @param idx column index.
     * @param figure  - 1 if X and any another number if O.
     * @return true if all fields in column marked as true.
     */
    private boolean checkVertical(int idx, int figure) {
        boolean result = true;
        for (Figure3T[] cell : table) {
            boolean figureMark = figure == 1 ? cell[idx].hasMarkX() : cell[idx].hasMarkO();
            if (!figureMark) {
                result = false;
                break;
            }
        }
        return result;
    }
    /**
     * Check diagonal fields for winner.
     * @param figure  - 1 if X and any another number if O.
     * @return true if all fields in any diagonal is true.
     */
    private boolean checkDiagonal(int figure) {
        int size = table.length;
        boolean result = true;
        for (int i = 0; i < size; i++) {
            boolean figureMarkLeft = figure == 1 ? this.table[i][i].hasMarkX() : this.table[i][i].hasMarkO();
            boolean figureMarkRight = figure == 1 ? this.table[i][size - i - 1].hasMarkX() : this.table[i][size - i - 1].hasMarkO();
            if (!figureMarkLeft && !figureMarkRight) {
                result = false;
                break;
            }
        }
        return result;
    }
    /**
     * Check win for X.
     * @return true if X is win.
     */
    public boolean isWinnerX() {
        if (checkDiagonal(1)) {
            return true;
        }
        for (int i = 0; i < table.length; i++) {
            if (checkVertical(i, 1) || checkHorizontal(i, 1)) {
                return true;
            }
        }

        return false;
    }
    /**
     * Check win for O.
     * @return true if O is win.
     */
    public boolean isWinnerO() {
        if (checkDiagonal(2)) {
            return true;
        }
        for (int i = 0; i < table.length; i++) {
            if (checkVertical(i, 2) || checkHorizontal(i, 2)) {
                return true;
            }
        }
        return false;
    }

    /**
     * check playing area for gap fields.
     * @return false if all fields is full.
     */
    public boolean hasGap() {
        boolean result = false;
        for (int i = 0; i < this.table[0].length; i++) {
            for (int j = 0; j < this.table[0].length; j++) {
                if (!this.table[i][j].hasMarkX() && !this.table[i][j].hasMarkO()) {
                    result = true;
                    break;
                }
            }
            if (result) {
                break;
            }
        }
        return result;
    }
}
