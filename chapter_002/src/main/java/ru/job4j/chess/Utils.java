package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;

/**
 * Class description.
 *
 * @author Vladimir Mytnik (vova@mytnik.net).
 * @version 0.1.
 */
public class Utils {
    public static boolean isDiagonal(Cell source, Cell dest) {
        return Math.abs(source.x - dest.x) == Math.abs(source.y - dest.y);
    }
    public static boolean isHorizontal(Cell source, Cell dest) {
        return source.x == dest.x;
    }
    public static boolean isVertical(Cell source, Cell dest) {
        return source.y == dest.y;
    }
}
