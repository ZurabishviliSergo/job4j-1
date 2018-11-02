package ru.job4j.chess;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.RookBlack;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class description.
 *
 * @author Vladimir Mytnik (vova@mytnik.net).
 * @version 0.1.
 */
public class RookBlackTest {
    private Board board = null;

    @Before
    public void makeNewFigureOnBoard() {
        this.board = new Board();
        RookBlack rook = new RookBlack(Cell.A1);
        board.add(rook);
    }

    @Test
    public void whenMoveUpThenGetTrue() {
        boolean addResult = this.board.move(Cell.A1, Cell.A5);
        assertThat(addResult, is(true));
    }

    @Test
    public void whenMoveRightThenGetTrue() {
        boolean addResult = this.board.move(Cell.A1, Cell.D1);
        assertThat(addResult, is(true));
    }

    @Test
    public void whenMoveDownThenGetTrue() {
        this.board.move(Cell.A1, Cell.A5);
        boolean moveResult = this.board.move(Cell.A5, Cell.A2);
        assertThat(moveResult, is(true));
    }

    @Test
    public void whenMoveLeftThenGetTrue() {
        this.board.move(Cell.A1, Cell.D1);
        boolean moveResult = this.board.move(Cell.D1, Cell.B1);
        assertThat(moveResult, is(true));
    }
}
