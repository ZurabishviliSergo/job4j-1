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
public class RookBlack implements Figure {
    private final Cell position;

    public RookBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps;
        if (Utils.isVertical(source, dest)) {
            steps = new Cell[Math.abs(source.x - dest.x)];
            int deltaX = source.x < dest.x ? 1 : -1;
            for (int i = 1; i <= steps.length; i++) {
                steps[i - 1] = Cell.find(source.x + (i * deltaX), source.y);
            }
        } else if (Utils.isHorizontal(source, dest)) {
            steps = new Cell[Math.abs(source.y - dest.y)];
            int deltaY = source.y < dest.y ? 1 : -1;
            for (int i = 1; i <= steps.length; i++) {
                steps[i - 1] = Cell.find(source.x, source.y + (i * deltaY));
            }
        } else {
            throw new ImpossibleMoveException("Wrong way for Black Rook");
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new RookBlack(dest);
    }
}
