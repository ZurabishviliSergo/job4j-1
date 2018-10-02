package ru.job4j.converter;

/**
 * Currency converter.
 */
public class Converter {

    /**
     * Convert RUR to EUR.
     * @param value rubles.
     * @return euros.
     */
    public int rubleToEuro(int value) {
        return value / 70;
    }

    /**
     * Convert RUR to USD.
     * @param value rubles.
     * @return dollars.
     */
    public int rubleToDollar(int value) {
        return value / 60;
    }

    /**
     * Convert EUR to RUR.
     * @param value euros.
     * @return rubles.
     */
    public int euroToRuble(int value) {
        return value * 70;
    }

    /**
     * Convert USD to RUR.
     * @param value dollars.
     * @return rubles.
     */
    public int dollarToRuble(int value) {
        return value * 60;
    }
}