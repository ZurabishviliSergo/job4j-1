package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.exceptions.ImpossibleMoveException;
import ru.job4j.chess.Utils;

/**
 *
 * @author Vladimir Mytnik (vova@mytnik.net)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (!Utils.isDiagonal(source, dest)) {
            throw new ImpossibleMoveException("Wrong way for Black Bishop");
        }
        Cell[] steps = new Cell[Math.abs(source.x - dest.x)];
        int deltaX = source.x < dest.x ? 1 : -1;
        int deltaY = source.y < dest.y ? 1 : -1;
        for (int i = 1; i <= steps.length; i++) {
            steps[i - 1] = Cell.find(source.x + (i * deltaX), source.y + (i * deltaY));
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }

}