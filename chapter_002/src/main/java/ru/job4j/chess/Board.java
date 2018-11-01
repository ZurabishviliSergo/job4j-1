package ru.job4j.chess;

import ru.job4j.chess.exceptions.*;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

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
    public boolean move(Cell source, Cell dest) {
        boolean result = true;
        boolean isHaveOnSource = false;
        boolean isCanMove = false;
        int figurePosition = -1;
        for (int i = 0; i < this.position; i++) {
            Figure figure = this.figures[i];
            if (figure.position() == source) {
                isHaveOnSource = true;
                figurePosition = i;
                try {
                    for (Cell cell : figure.way(source, dest)) {
                        if (cell != null && cell.equals(dest)) {
                            isCanMove = true;
                        }
                        for (Figure figureInner : this.figures) {
                            if (figureInner != null && cell == figureInner.position()) {
                                throw new OccupiedWayException("This way is not free.");
                            }
                        }
                    }
                } catch (ImpossibleMoveException ime) {
                    result = false;
                }
                break;
            }
        }
        if (!isHaveOnSource) {
            throw new FigureNotFoundException("Not have any figure at source cell.");
        }
        if (!isCanMove) {
            throw new ImpossibleMoveException("Wrong way!");
        }
        this.figures[figurePosition] = this.figures[figurePosition].copy(dest);
        return result;
    }
}
