package ru.job4j.chess;

import ru.job4j.chess.exceptions.*;

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
        for (Figure figure : figures) {
            boolean IsHaveOnSourse = false;
            boolean IsCanMove = false;
            boolean IsFreeWay = true;
            try {
                if (figure.position().equals(source)) {
                    IsHaveOnSourse = true;
                    for (Cell cell : figure.way(source, dest)) {
                        if (cell.equals(dest)) {
                            IsCanMove = true;
                        }
                        for (Figure figureInner : this.figures) {
                            if (cell.equals(figureInner.position())) {
                                IsFreeWay = false;
                                break;
                            }
                        }
                    }
                    break;
                }
            } catch (ImpossibleMoveException ime) {
                System.out.println(ime.toString());
            }
            if (!IsHaveOnSourse) {
                throw new FigureNotFoundException("Not have any figure at source cell.");
            } else if (!IsCanMove) {
                throw new ImpossibleMoveException("Wrong way!");
            } else if (IsFreeWay) {
                throw new OccupiedWayException("This way is not free.");
            } else {
                figure = figure.copy(dest);
            }
        }
        return true;
    }
}
