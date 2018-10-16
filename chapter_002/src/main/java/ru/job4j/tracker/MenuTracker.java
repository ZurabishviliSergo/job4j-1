package ru.job4j.tracker;

public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[7];

    boolean exit = false;

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void fillActions() {
        this.actions[0] = this.new addAction();
        this.actions[1] = new MenuTracker.geAllAction();
        this.actions[2] = new editAction();
        this.actions[3] = this.new deleteAction();
        this.actions[4] = this.new findByIdAction();
        this.actions[5] = this.new findByNameAction();
        this.actions[6] = this.new exitAction();
    }

    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    /**
     * Print user menu.
     */
    public void show() {
        System.out.println("Menu.");
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.title());
            }
        }
    }

    public void init() {
        do {
            this.show();
            this.select(Integer.parseInt(input.ask("Select: ")));
        } while (!this.exit);
    }
    /**
     * Add new request to the storage.
     */
    public class addAction implements UserAction {
        @Override
        public String key() {
            return "0";
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Add new request --------------");
            String name = input.ask("Type request name: ");
            String desc = input.ask("Type request description: ");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println("------------ New request getId : " + item.getId() + " -----------");
        }
        @Override
        public String title() {
            return String.format("%s. %s", this.key(), "Add new Item");
        }
    }

    /**
     * Show all requests.
     */
    private class geAllAction implements UserAction {
        @Override
        public String key() {
            return "1";
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Show all requests --------------");
            Item[] allItems = tracker.getAll();
            if (allItems.length == 0) {
                System.out.println("There are no requests at this time");
            } else {
                for (Item item : allItems) {
                    System.out.println(item.toString());
                }
            }
            System.out.println("------------ Total requests : " + allItems.length + " -----------");
        }
        @Override
        public String title() {
            return String.format("%s. %s", this.key(), "Show all items");
        }
    }

    /**
     * Delete request from storage.
     */
    private class deleteAction implements UserAction {
        @Override
        public String key() {
            return "3";
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Delete request --------------");
            String id = input.ask("Type request id: ");
            if (tracker.delete(id)) {
                System.out.println("Request with ID" + id + " has been deleted.");
            } else {
                System.out.println("There are no request with id " + id);
            }
            System.out.println("------------ Done --------------");
        }
        @Override
        public String title() {
            return String.format("%s. %s", this.key(), "Delete item");
        }
    }

    /**
     * Find request by ID.
     */
    private class findByIdAction implements UserAction {
        @Override
        public String key() {
            return "4";
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Find request by ID --------------");
            String id = input.ask("Type request ID: ");
            Item item = tracker.findById(id);
            if (item != null) {
                System.out.println(item.toString());
            } else {
                System.out.println("Can't find item with ID " + id);
            }
            System.out.println("------------ Done -----------");
        }
        @Override
        public String title() {
            return String.format("%s. %s", this.key(), "Find item by Id");
        }

    }

    /**
     * Find requests by name.
     */
    private class findByNameAction implements UserAction {
        @Override
        public String key() {
            return "5";
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Find requests by name --------------");
            String name = input.ask("Type request name: ");
            Item[] items = tracker.findByName(name);
            if (items.length == 0) {
                System.out.println("Can't find requests with name " + name);
            } else {
                for (Item item : items) {
                    System.out.println(item.toString());
                }
            }
            System.out.println("------------ Total results: " + items.length + " -----------");
        }
        @Override
        public String title() {
            return String.format("%s. %s", this.key(), "Find items by name");
        }

    }

    private class exitAction implements UserAction {
        @Override
        public String key() {
            return "6";
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            exit = true;
        }
        @Override
        public String title() {
            return String.format("%s. %s", this.key(), "Exit Program");
        }

    }
}

/**
 * Edit request.
 */
class editAction implements UserAction {
    @Override
    public String key() {
        return "2";
    }
    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Edit request --------------");
        String id = input.ask("Type request id: ");
        String name = input.ask("Type request new name: ");
        String desc = input.ask("Type request new description: ");
        Item item = new Item(name, desc);
        if (tracker.replace(id, item)) {
            System.out.println("------------ Request edited! --------------");
        } else {
            System.out.println("------------ Can't find request with ID" + id + "--------------");
        }
    }
    @Override
    public String title() {
        return String.format("%s. %s", this.key(), "Edit item");
    }
}
