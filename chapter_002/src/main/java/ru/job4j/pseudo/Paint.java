package ru.job4j.pseudo;

/**
 * Draw Shape class figures. Strategy pattern in action.
 * @author Vladimir Mytnik (vova@mytnik.net)
 * @version 0.1
 */
public class Paint {
    /**
     * Draw figure extended Shape class.
     * @param shape - figure.
     */
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }
}
