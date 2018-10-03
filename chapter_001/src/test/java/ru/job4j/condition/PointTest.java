package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.*;

public class PointTest {
    @Test
    public void whenDistanceIsTwo() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        double result = a.distanceTo(b);
        assertThat(result, closeTo(2, 0.1));
    }
    @Test
    public void whenDistanceIsNull() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 0);
        double result = a.distanceTo(b);
        assertThat(result, closeTo(0, 0.1));
    }
}
