package ru.job4j.chess;

import ru.job4j.chess.exceptions.ImpossibleMoveException;

abstract class Figure {
    private final Cell position;

    public Figure(Cell position) {
        this.position = position;
    }

    abstract Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException;

    abstract Figure copy(Cell dest);

    public Cell position() {
        return this.position;
    }
}
