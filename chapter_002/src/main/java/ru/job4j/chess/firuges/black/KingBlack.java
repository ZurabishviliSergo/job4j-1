package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.exceptions.ImpossibleMoveException;

/**
 *
 * @author Vladimir Mytnik (vova@mytnik.net)
 * @version $Id$
 * @since 0.1
 */
public class KingBlack implements Figure {
    private final Cell position;

    public KingBlack(Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (Math.abs(source.x - dest.x) > 1 || Math.abs(source.y - dest.y) > 1) {
            throw new ImpossibleMoveException("Wrong way for Black King");
        }
        Cell[] steps = {dest};
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new KingBlack(dest);
    }
}