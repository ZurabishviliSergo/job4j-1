package ru.job4j.tracker;

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

    /**
     * Fields initialization constructor.
     * @param input data input.
     * @param tracker requests storage.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Main cycle.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        int key;
        do {
            menu.show();
            key = input.ask("Select", menu.getMenuRange());
            menu.select(key);
        } while (key != 6);
    }

    /**
     * Start application.
     * @param args - app command line arguments.
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(), new Tracker()).init();
    }
}