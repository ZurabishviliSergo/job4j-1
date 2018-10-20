package ru.job4j.chess;

import ru.job4j.chess.exceptions.*;
import ru.job4j.chess.firuges.Cell;

public class Board {

    private final Figure[] figures = new Figure[32];
    private int position = 0;

    public void add(Figure figure) {
        this.figures[position++] = figure;
    }

    public boolean move(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        for (Figure figure : this.figures) {
            Cell[] figureWay = figure.way(source, dest);

        }
        return true;
    }
}
