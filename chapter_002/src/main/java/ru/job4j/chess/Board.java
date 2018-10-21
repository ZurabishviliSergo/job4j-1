package ru.job4j.chess;

import ru.job4j.chess.exceptions.*;
import ru.job4j.chess.firuges.Cell;

/**
 * Game board. Contains all figures and check opportunity to move.
 * @author Vladimir Mytnik (vova@mytnik.net).
 * @version 0.1.
 */
public class Board {
    /**
     * Figures array.
     */
    private final Figure[] figures = new Figure[32];
    /**
     * Pointer to adding new figure.
     */
    private int position = 0;

    /**
     * Add new figure to figure array method.
     * @param figure - new figure to add.
     */
    public void add(Figure figure) {
        this.figures[position++] = figure;
    }

    /**
     * Check opportunity and move figure.
     * @param source - start position.
     * @param dest - end position.
     * @return - true if figure is moved.
     * @throws ImpossibleMoveException - wrong way for current figure.
     * @throws OccupiedWayException - move way include another figure.
     * @throws FigureNotFoundException - not have any figure at source cell.
     */
    public boolean move(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        boolean isExistAtSource = false;
        boolean isCanMove = false;
        for (Figure figure : this.figures) {
            Cell[] figureWay = figure.way(source, dest);
            if (figureWay[0].equals(source)) {
                isExistAtSource = true;

                for (Cell cell : figureWay) {
                    if (cell.equals(dest)) {
                        isCanMove = true;
                        break;
                    }
                }
                break;
            }
        }
        if (!isExistAtSource) {
            throw new FigureNotFoundException("Not have any figure at source cell.");
        }
        if (!isCanMove) {
            throw new ImpossibleMoveException("Wrong way!");
        }
        return true;
    }
}
