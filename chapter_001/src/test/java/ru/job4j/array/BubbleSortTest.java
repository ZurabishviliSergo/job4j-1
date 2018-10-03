package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BubbleSortTest {
    @Test
    public void whenArray51273Then12357() {
        BubbleSort bs = new BubbleSort();
        int[] arr = {5, 1, 2, 7, 3};
        int[] result = bs.sort(arr);
        int[] expected = {1, 2, 3, 5, 7};
        assertThat(result, is(expected));
    }
    @Test
    public void whenArray512736Then123567() {
        BubbleSort bs = new BubbleSort();
        int[] arr = {5, 1, 2, 7, 3, 6};
        int[] result = bs.sort(arr);
        int[] expected = {1, 2, 3, 5, 6, 7};
        assertThat(result, is(expected));
    }
    @Test
    public void whenArray21Then12() {
        BubbleSort bs = new BubbleSort();
        int[] arr = {2, 1};
        int[] result = bs.sort(arr);
        int[] expected = {1, 2};
        assertThat(result, is(expected));
    }
}
