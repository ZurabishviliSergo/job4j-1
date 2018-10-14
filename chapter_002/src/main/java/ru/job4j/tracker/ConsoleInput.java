package ru.job4j.tracker;

import java.util.*;

public class ConsoleInput implements Input {
    public String ask (String question) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }
}
