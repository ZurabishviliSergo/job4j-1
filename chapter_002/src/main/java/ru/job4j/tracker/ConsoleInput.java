package ru.job4j.tracker;

import java.util.*;

public class ConsoleInput implements Input {
    public String ask (String question) {
        System.out.println(question);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
