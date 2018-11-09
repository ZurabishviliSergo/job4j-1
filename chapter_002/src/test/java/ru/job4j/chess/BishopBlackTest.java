package ru.job4j.chess;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

/**
 * Class description.
 *
 * @author Vladimir Mytnik (vova@mytnik.net).
 * @version 0.1.
 */
public class BishopBlackTest {
    private Board board = null;

    @Before
    public void makeNewFigureOnBoard() {
        this.board = new Board();
        BishopBlack bishop = new BishopBlack(Cell.C1);
        board.add(bishop);
    }

    @Test
    public void whenMoveUpAndRightThenGetTrue() {
        boolean addResult = this.board.move(Cell.C1, Cell.G5);
        assertThat(addResult, is(true));
    }

    @Test
    public void whenMoveUpAndLeftThenGetTrue() {
        boolean addResult = this.board.move(Cell.C1, Cell.B2);
        assertThat(addResult, is(true));
    }

    @Test
    public void whenMoveDownAndRightThenGetTrue() {
        this.board.move(Cell.C1, Cell.G5);
        boolean moveResult = this.board.move(Cell.G5, Cell.H4);
        assertThat(moveResult, is(true));
    }

    @Test
    public void whenMoveDownAndLeftThenGetTrue() {
        this.board.move(Cell.C1, Cell.G5);
        boolean moveResult = this.board.move(Cell.G5, Cell.E3);
        assertThat(moveResult, is(true));
    }
}
