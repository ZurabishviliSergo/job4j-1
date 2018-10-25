package ru.job4j.chess;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

/**
 * Unit test for Board Class.
 */
public class BoardTest {
    @Test
    public void whenMoveFigureThenGetTrue() {
        Board board = new Board();
        BishopBlack bishop = new BishopBlack(Cell.A1);
        board.add(bishop);
        boolean addResult = board.move(Cell.A1, Cell.D4);
        assertThat(addResult, is(true));
    }
}