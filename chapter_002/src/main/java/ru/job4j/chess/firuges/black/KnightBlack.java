package ru.job4j.chess.firuges.black;

import ru.job4j.chess.exceptions.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class KnightBlack implements Figure {
    private final Cell position;

    public KnightBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (!(Math.abs(source.x - dest.x) == 1 && Math.abs(source.y - dest.y) == 2
                || Math.abs(source.x - dest.x) == 2 && Math.abs(source.y - dest.y) == 1)) {
            throw new ImpossibleMoveException("Wrong way for Black Knight");
        }
        return new Cell[]{dest};
    }

    @Override
    public Figure copy(Cell dest) {
        return new KnightBlack(dest);
    }
}
