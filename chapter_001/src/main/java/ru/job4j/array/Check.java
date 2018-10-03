package ru.job4j.array;

public class Check {
    public boolean mono(boolean[] data) {
        boolean arrFlag = data[0];
        for (boolean el : data) {
            if (el != arrFlag) {
                return false;
            }
        }
        return true;
    }
}
