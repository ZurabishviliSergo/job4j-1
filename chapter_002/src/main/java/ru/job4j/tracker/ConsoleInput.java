package ru.job4j.tracker;

import java.util.*;

public class ConsoleInput implements Input {
    @Override
    public String ask(String question) {
        System.out.println(question);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist  = false;
        for (int el : range) {
            if (key == el) {
                exist = true;
                break;
            }
        }
        if (!exist) { throw new MenuOutException("Out of menu range."); }
        return key;
    }
}
