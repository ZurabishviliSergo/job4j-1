package ru.job4j.chess;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.KingBlack;

/**
 * Class description.
 *
 * @author Vladimir Mytnik (vova@mytnik.net).
 * @version 0.1.
 */
public class KingBlackTest {
    private Board board = null;

    @Before
    public void makeNewFigureOnBoard() {
        this.board = new Board();
        KingBlack king = new KingBlack(Cell.E1);
        board.add(king);
    }

    @Test
    public void whenMoveUpAndRightThenGetTrue() {
        boolean addResult = this.board.move(Cell.E1, Cell.F2);
        assertThat(addResult, is(true));
    }

    @Test
    public void whenMoveUpAndLeftThenGetTrue() {
        boolean addResult = this.board.move(Cell.E1, Cell.D2);
        assertThat(addResult, is(true));
    }

    @Test
    public void whenMoveDownAndRightThenGetTrue() {
        this.board.move(Cell.E1, Cell.F2);
        boolean moveResult = this.board.move(Cell.F2, Cell.G1);
        assertThat(moveResult, is(true));
    }

    @Test
    public void whenMoveDownAndLeftThenGetTrue() {
        this.board.move(Cell.E1, Cell.D2);
        boolean moveResult = this.board.move(Cell.D2, Cell.C1);
        assertThat(moveResult, is(true));
    }
}