package ru.job4j.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {
    @Test
    public void whenFirstLessSecond() {
        Max maxim = new Max();
        int result = maxim.max(1, 2);
        assertThat(result, is(2));
    }
    @Test
    public void whenSecondLessFirst() {
        Max maxim = new Max();
        int result = maxim.max(2, 1);
        assertThat(result, is(2));
    }
    @Test
    public void whenEquals() {
        Max maxim = new Max();
        int result = maxim.max(2, 2);
        assertThat(result, is(2));
    }
    @Test
    public void whenSecondNegative() {
        Max maxim = new Max();
        int result = maxim.max(2, -1);
        assertThat(result, is(2));
    }
    @Test
    public void whenFirstEqualsNull() {
        Max maxim = new Max();
        int result = maxim.max(0, -1);
        assertThat(result, is(0));
    }
    @Test
    public void whenFirstMoreSecondAndThird() {
        Max maxim = new Max();
        int result = maxim.max(3, 2, 1);
        assertThat(result, is(3));
    }
    @Test
    public void whenSecondMoreFirstAndThird() {
        Max maxim = new Max();
        int result = maxim.max(2, 3, 1);
        assertThat(result, is(3));
    }
    @Test
    public void whenThirdMoreFirstAndSecond() {
        Max maxim = new Max();
        int result = maxim.max(1, 2, 3);
        assertThat(result, is(3));
    }
    @Test
    public void whenThreeArgsEqual() {
        Max maxim = new Max();
        int result = maxim.max(2, 2, 2);
        assertThat(result, is(2));
    }
}
