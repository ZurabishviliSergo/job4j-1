package ru.job4j.chess;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.QueenBlack;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class description.
 *
 * @author Vladimir Mytnik (vova@mytnik.net).
 * @version 0.1.
 */
public class QueenBlackTest {
    private Board board = null;

    @Before
    public void MakeNewFigureOnBoard() {
        this.board = new Board();
        QueenBlack queen = new QueenBlack(Cell.D1);
        board.add(queen);
    }

    @Test
    public void whenMoveUpThenGetTrue() {
        boolean addResult = this.board.move(Cell.D1, Cell.D5);
        assertThat(addResult, is(true));
    }

    @Test
    public void whenMoveRightThenGetTrue() {
        boolean addResult = this.board.move(Cell.D1, Cell.G1);
        assertThat(addResult, is(true));
    }

    @Test
    public void whenMoveDownThenGetTrue() {
        this.board.move(Cell.D1, Cell.D5);
        boolean moveResult = this.board.move(Cell.D5, Cell.D3);
        assertThat(moveResult, is(true));
    }

    @Test
    public void whenMoveLeftThenGetTrue() {
        this.board.move(Cell.D1, Cell.G1);
        boolean moveResult = this.board.move(Cell.G1, Cell.F1);
        assertThat(moveResult, is(true));
    }

    @Test
    public void whenMoveUpAndRightThenGetTrue() {
        boolean addResult = this.board.move(Cell.D1, Cell.G4);
        assertThat(addResult, is(true));
    }

    @Test
    public void whenMoveUpAndLeftThenGetTrue() {
        boolean addResult = this.board.move(Cell.D1, Cell.B3);
        assertThat(addResult, is(true));
    }

    @Test
    public void whenMoveDownAndRightThenGetTrue() {
        this.board.move(Cell.D1, Cell.G4);
        boolean moveResult = this.board.move(Cell.G4, Cell.H3);
        assertThat(moveResult, is(true));
    }

    @Test
    public void whenMoveDownAndLeftThenGetTrue() {
        this.board.move(Cell.D1, Cell.B3);
        boolean moveResult = this.board.move(Cell.B3, Cell.A2);
        assertThat(moveResult, is(true));
    }
}
