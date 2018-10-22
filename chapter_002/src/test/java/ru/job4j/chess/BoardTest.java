//package ru.job4j.chess;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import ru.job4j.chess.exceptions.FigureNotFoundException;
//import ru.job4j.chess.exceptions.ImpossibleMoveException;
//import ru.job4j.chess.exceptions.OccupiedWayException;
//
//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;
//
//import static org.hamcrest.core.Is.is;
//import static org.junit.Assert.assertThat;
//
///**
// * Unit test for Board Class.
// */
//public class BoardTest {
//    private final PrintStream stdout = System.out;
//    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
//
//    @Before
//    public void loadOutput() {
//        System.setOut(new PrintStream(this.out));
//    }
//
//    @After
//    public void backOutput() {
//        System.setOut(this.stdout);
//    }
//
//    @Test
//    public void whenMoveBishopThenGetNewPosition() {
//        Board board = new Board();
//        Bishop bishop = new Bishop(new Cell(1, 1));
//        board.add(bishop);
//        try {
//            boolean addResult = board.move(new Cell(1, 1), new Cell(4, 4));
//        } catch (ImpossibleMoveException ime) {
//            System.out.println("ime");
//        } catch (OccupiedWayException owe) {
//            System.out.println("owe");
//        } catch (FigureNotFoundException fnf) {
//            System.out.println("fnf");
//        }
//
//        assertThat(new String(this.out.toByteArray()), is(
//                new StringBuilder()
//                        .append(this.userMenu)
//                        .append("------------ Find requests by name --------------")
//                        .append(System.lineSeparator())
//                        .append(item2.toString())
//                        .append(System.lineSeparator())
//                        .append("------------ Total results: 1 -----------")
//                        .append(System.lineSeparator())
//                        .append(this.userMenu)
//                        .toString()
//                )
//        );
//    }
//}

