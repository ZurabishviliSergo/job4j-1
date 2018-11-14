package ru.job4j.lambda;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class description.
 *
 * @author Vladimir Mytnik (vova@mytnik.net).
 * @version 0.1.
 * @since 11/13/18
 */
public class FuncTest {
    @Test
    public void whenLinear() {
        List<Double> result = new Func().linear(1, 5);
        List<Double> expected = new ArrayList<>(Arrays.asList(1D, 2D, 3D, 4D, 5D));
        assertThat(result, is(expected));
    }
    @Test
    public void whenQuadro() {
        List<Double> result = new Func().quadratic(1, 5);
        List<Double> expected = new ArrayList<>(Arrays.asList(1D, 4D, 9D, 16D, 25D));
        assertThat(result, is(expected));
    }
    @Test
    public void whenLog() {
        List<Double> result = new Func().log(1, 5);
        List<Double> expected = new ArrayList<>(Arrays.asList(0D, Math.log(2), Math.log(3), Math.log(4), Math.log(5)));
        assertThat(result, is(expected));
    }
}
