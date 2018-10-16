package ru.job4j.tracker;

public class ValidateInput extends ConsoleInput {
    @Override
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Select numbers only from menu!");
            } catch (NumberFormatException nfe) {
                System.out.println("Type only numbers!");
            }
        } while (invalid);
        return value;
    }
}
