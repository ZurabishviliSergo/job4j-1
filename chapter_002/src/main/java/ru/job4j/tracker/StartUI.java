package ru.job4j.tracker;

import java.util.function.Consumer;
/**
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
    /**
     * Getting user data.
     */
    private final Input input;
    /**
     * Requests storage.
     */
    private final Tracker tracker;

    private boolean exit = false;

    private final Consumer output;
    /**
     * Fields initialization constructor.
     * @param input data input.
     * @param tracker requests storage.
     */
    public StartUI(Input input, Tracker tracker, Consumer output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    public void stop() {
        this.exit = true;
    }

    /**
     * Main cycle.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker, this.output);
        menu.fillActions(this);
        int key;
        do {
            menu.show();
            key = input.ask("Select", menu.getMenuRange());
            menu.select(key);
        } while (!exit);
    }

    /**
     * Start application.
     * @param args - app command line arguments.
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker(), System.out::println).init();
    }
}