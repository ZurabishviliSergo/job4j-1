package ru.job4j.pseudo;

/**
 * Triangle figure.
 * @author Vladimir Mytnik (vova@mytnik.net)
 * @version 0.1
 */
public class Square implements Shape {
    /**
     * Draw Square figure.
     * @return - square string.
     */
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("++++");
        pic.append("++++");
        pic.append("++++");
        pic.append("++++");
        return pic.toString();
    }
}
