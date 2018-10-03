package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TurnTest {
    @Test
    public void whenArrayLengthOdd() {
        Turn t = new Turn();
        int[] arr = {1, 2, 3, 4};
        int[] result = t.turn(arr);
        int[] expected = {4, 3, 2, 1};
        assertThat(result, is(expected));
    }
    @Test
    public void whenArrayLengthEven() {
        Turn t = new Turn();
        int[] arr = {1, 2, 3, 4, 5};
        int[] result = t.turn(arr);
        int[] expected = {5, 4, 3, 2, 1};
        assertThat(result, is(expected));
    }
}
