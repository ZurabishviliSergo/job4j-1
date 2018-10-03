package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CheckTest {
    @Test
    public void whenArrayLengthOddAndAllElementsTrueThenTrue() {
        Check c = new Check();
        boolean[] arr = {true, true, true};
        boolean result = c.mono(arr);
        assertThat(result, is(true));
    }
    @Test
    public void whenArrayLengthEvenAndAllElementsTrueThenTrue() {
        Check c = new Check();
        boolean[] arr = {true, true, true, true};
        boolean result = c.mono(arr);
        assertThat(result, is(true));
    }
    @Test
    public void whenArrayLengthEvenAndAllElementsFalseThenTrue() {
        Check c = new Check();
        boolean[] arr = {false, false, false, false};
        boolean result = c.mono(arr);
        assertThat(result, is(true));
    }
    @Test
    public void whenArrayLengthOddAndAllElementsFalseThenTrue() {
        Check c = new Check();
        boolean[] arr = {false, false, false};
        boolean result = c.mono(arr);
        assertThat(result, is(true));
    }
    @Test
    public void whenArrayLengthOddAndElementsDifferentThenFalse() {
        Check c = new Check();
        boolean[] arr = {false, true, false};
        boolean result = c.mono(arr);
        assertThat(result, is(false));
    }
    @Test
    public void whenArrayLengthEvenAndElementsDifferentThenFalse() {
        Check c = new Check();
        boolean[] arr = {false, true, false, false};
        boolean result = c.mono(arr);
        assertThat(result, is(false));
    }
}
