package ru.job4j.chess;

import ru.job4j.chess.exceptions.ImpossibleMoveException;

public class Bishop extends Figure {

    public Bishop(Cell position) {
        super(position);
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        if (!isDiagonal(source, dest)) {
            throw new ImpossibleMoveException("Wrong way for bishop");
        }
        Cell[] steps = new Cell[Math.abs(source.getX() - dest.getX())];
        int deltaX = source.getX() < dest.getX() ? 1 : -1;
        int deltaY = source.getY() < dest.getY() ? 1 : -1;
        for (int i = 1; i <= steps.length; i++) {
            steps[i - 1] = new Cell(source.getX() + (i * deltaX), source.getY() + (i * deltaY));
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new Bishop(dest);
    }

    private boolean isDiagonal(Cell source, Cell dest) {
        return Math.abs(source.getX() - dest.getX()) == Math.abs(source.getY() - dest.getY());
    }

}
