package ru.job4j.array;

public class Check {
    public boolean mono(boolean[] data) {
        boolean result = true;
        boolean arrFlag = data[0];
        for (boolean el : data) {
            if (arrFlag != el) {
                result = false;
                break;
            }
        }
        return result;
    }
}
