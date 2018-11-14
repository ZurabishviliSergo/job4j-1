package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
/**
 * Class description.
 *
 * @author Vladimir Mytnik (vova@mytnik.net).
 * @version 0.1.
 * @since 11/13/18
 */
public class Func {
    private List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> result = new ArrayList<>();
        for (double i = start; i <= end; i++) {
            result.add(func.apply(i));
        }
        return result;
    }
    public List<Double> linear(int start, int end) {
        return this.diapason(start, end, x -> x);
    }
    public List<Double> quadratic(int start, int end) {
        return this.diapason(start, end, x -> x * x);
    }
    public List<Double> log(int start, int end) {
        return this.diapason(start, end, Math::log);
    }
}