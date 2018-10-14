package ru.job4j.tracker;

/**
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
    /**
     * Add new request menu constant.
     */
    private static final String ADD = "0";

    /**
     * Show all requests menu constant.
     */
    private static final String SHOW = "1";

    /**
     * Edit request menu constant.
     */
    private static final String EDIT = "2";

    /**
     * Delete request menu constant.
     */
    private static final String DEL = "3";

    /**
     * Find by ID request menu constant.
     */
    private static final String FIND_ID = "4";

    /**
     * Find by name request menu constant.
     */
    private static final String FIND_NAME = "5";

    /**
     * Brake cycle menu constant.
     */
    private static final String EXIT = "6";
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
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Type menu item : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOW.equals(answer)) {
                this.showItems();
            } else if (DEL.equals(answer)) {
                this.delItem();
            } else if (EDIT.equals(answer)) {
                this.editItem();
            } else if (SHOW.equals(answer)) {
                this.showItems();
            } else if (SHOW.equals(answer)) {
                this.showItems();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    /**
     * Add new request to the storage method.
     */
    private void createItem() {
        System.out.println("------------ Add new request --------------");
        String name = this.input.ask("Type request name: ");
        String desc = this.input.ask("Type request description: ");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ New request getId : " + item.getId() + "-----------");
    }

    /**
     * Show all requests.
     */
    private void showItems() {
        System.out.println("------------ Show all requests --------------");
        Item[] allItems = tracker.getAll();
        if (allItems.length == 0) {
            System.out.println("There are no requests at this time.");
        }
        else {
            for (Item item : allItems) {
                System.out.println("\t- " + item.getName() + " ID:" + item.getId());
                System.out.println("\t\t" + item.getBody());
                System.out.println("---");
            }
        }
        System.out.println("------------ Total requests : " + allItems.length + "-----------");
    }

    /**
     * Delete request from storage.
     */
    private void delItem() {
        System.out.println("------------ Delete request --------------");
        String id = this.input.ask("Type request id: ");
        String name = tracker.delete(id);
        if (!name.equals(null)) {
            System.out.println("Request \"" + name + "\" has been deleted.");
        }
        else {
            System.out.println("There are no request with id " + id);
        }
        System.out.println("------------ Show all requests --------------");
    }

    /**
     * Delete request from storage.
     */
    private void editItem() {
        System.out.println("------------ Edit request --------------");
        String id = this.input.ask("Type request id: ");
        String name = tracker.delete(id);
        if (!name.equals(null)) {
            System.out.println("Request \"" + name + "\" has been deleted.");
        }
        else {
            System.out.println("There are no request with id " + id);
        }
        System.out.println("------------ Show all requests --------------");
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
        System.out.println("Select:");
    }

    /**
     * Start application.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}