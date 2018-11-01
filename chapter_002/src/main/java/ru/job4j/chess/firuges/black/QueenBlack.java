package ru.job4j.chess.firuges.black;

import ru.job4j.chess.exceptions.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.Utils;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class QueenBlack implements Figure {
    private final Cell position;

    public QueenBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps;
        if (Utils.isDiagonal(source, dest)) {
            steps = new BishopBlack(source).way(source, dest);
        } else if (Utils.isHorizontal(source, dest) || Utils.isVertical(source, dest)) {
            steps = new RookBlack(source).way(source, dest);
        } else {
            throw new ImpossibleMoveException("Wrong way for Black Queen");
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new QueenBlack(dest);
    }

}
