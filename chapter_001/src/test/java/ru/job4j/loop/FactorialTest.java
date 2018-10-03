package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FactorialTest {
    @Test
    public void factForFive() {
        Factorial fact = new Factorial();
        int result = fact.calc(5);
        assertThat(result, is(120));
    }
    @Test
    public void factForNull() {
        Factorial fact = new Factorial();
        int result = fact.calc(0);
        assertThat(result, is(1));
    }
    @Test
    public void factForOne() {
        Factorial fact = new Factorial();
        int result = fact.calc(1);
        assertThat(result, is(1));
    }
}
