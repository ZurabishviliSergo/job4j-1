package ru.job4j.chess;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.KnightBlack;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class description.
 *
 * @author Vladimir Mytnik (vova@mytnik.net).
 * @version 0.1.
 */
public class KnightBlackTest {
    private Board board = null;

    @Before
    public void makeNewFigureOnBoard() {
        this.board = new Board();
        KnightBlack knight = new KnightBlack(Cell.B1);
        board.add(knight);
    }

    @Test
    public void whenMoveUpAndRightThenGetTrue() {
        boolean addResult = this.board.move(Cell.B1, Cell.C3);
        assertThat(addResult, is(true));
    }

    @Test
    public void whenMoveUpAndLeftThenGetTrue() {
        boolean addResult = this.board.move(Cell.B1, Cell.A3);
        assertThat(addResult, is(true));
    }

    @Test
    public void whenMoveDownAndRightThenGetTrue() {
        this.board.move(Cell.B1, Cell.A3);
        boolean moveResult = this.board.move(Cell.A3, Cell.B1);
        assertThat(moveResult, is(true));
    }

    @Test
    public void whenMoveDownAndLeftThenGetTrue() {
        this.board.move(Cell.B1, Cell.C3);
        boolean moveResult = this.board.move(Cell.C3, Cell.B1);
        assertThat(moveResult, is(true));
    }
}
