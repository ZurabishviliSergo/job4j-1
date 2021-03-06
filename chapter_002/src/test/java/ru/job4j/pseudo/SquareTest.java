package ru.job4j.pseudo;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Square tests.
 * @author Vladimir Mytnik (vova@mytnik.net)
 * @version 0.1
 */
public class SquareTest {
    @Test
    public void whenMakeSquareThenDrawStringWithSquareFigure() {
        Square square = new Square();
        assertThat(square.draw(), is(
                new StringBuilder()
                        .append("++++")
                        .append("++++")
                        .append("++++")
                        .append("++++")
                        .toString()
                )
        );
    }
}
