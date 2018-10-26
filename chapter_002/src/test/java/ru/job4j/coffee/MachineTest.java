package ru.job4j.coffee;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MachineTest {
    @Test
    public void whenPayFiftyThenChangeTenAndFive() {
        Machine machine = new Machine();
        int[] result = machine.makeChange(50);
        int[] expected = {10, 5};
        assertThat(result, is(expected));
    }

    @Test
    public void whenPayFortyThreeThenChangeFiveAndTwoAndOne() {
        Machine machine = new Machine();
        int[] result = machine.makeChange(43);
        int[] expected = {5, 2, 1};
        assertThat(result, is(expected));
    }
}
