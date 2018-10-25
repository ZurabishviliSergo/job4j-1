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
    public void MakeNewFigureOnBoard(){
        this.board = new Board();
        BishopBlack bishop = new BishopBlack(Cell.D4);
        board.add(bishop);
    }
    @Test
    public void whenMoveUpAndRightThenGetTrue() {
        boolean addResult = this.board.move(Cell.D4, Cell.G7);
        assertThat(addResult, is(true));
    }

    @Test
    public void whenMoveDownAndRightThenGetTrue() {
        boolean addResult = this.board.move(Cell.D4, Cell.G1);
        assertThat(addResult, is(true));
    }

    @Test
    public void whenMoveDownAndLeftThenGetTrue() {
        boolean addResult = this.board.move(Cell.D4, Cell.A1);
        assertThat(addResult, is(true));
    }

    @Test
    public void whenMoveUpAndLeftThenGetTrue() {
        boolean addResult = this.board.move(Cell.D4, Cell.B6);
        assertThat(addResult, is(true));
    }
}
