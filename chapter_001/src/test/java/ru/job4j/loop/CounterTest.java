package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CounterTest {
    @Test
    public void fromOneToTen() {
        Counter count = new Counter();
        int result = count.add(1, 10);
        assertThat(result, is(30));
    }
    @Test
    public void whenResultNull() {
        Counter count = new Counter();
        int result = count.add(0, 1);
        assertThat(result, is(0));
    }
    @Test
    public void whenOneOdd() {
        Counter count = new Counter();
        int result = count.add(0, 2);
        assertThat(result, is(2));
    }
    @Test
    public void whenFirstOdd() {
        Counter count = new Counter();
        int result = count.add(2, 4);
        assertThat(result, is(6));
    }
}
