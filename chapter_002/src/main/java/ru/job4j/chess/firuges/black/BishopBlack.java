package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.Figure;
import ru.job4j.chess.exceptions.ImpossibleMoveException;

/**
 *
 * @author Vladimir Mytnik (vova@mytnik.net)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack extends Figure {

    public BishopBlack(Cell position) {
        super(position);
    }

    public Cell[] way(Cell source, Cell dest) {
        if (!isDiagonal(source, dest)) {
            throw new ImpossibleMoveException("Wrong way for bishop");
        }
        Cell[] steps = new Cell[Math.abs(source.x - dest.y)];
        int deltaX = source.x < dest.x ? 1 : -1;
        int deltaY = source.y < dest.y ? 1 : -1;
        for (int i = 1; i <= steps.length; i++) {
            steps[i - 1] = Cell.find(source.x + (i * deltaX), source.y + (i * deltaY));
        }
        return steps;
    }

    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }

    private boolean isDiagonal(Cell source, Cell dest) {
        return Math.abs(source.x - dest.x) == Math.abs(source.y - dest.y);
    }

}