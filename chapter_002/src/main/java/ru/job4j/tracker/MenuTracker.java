package ru.job4j.tracker;

public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[7];

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void fillActions() {
        this.actions[0] = this.new AddAction("0", "Add new Item");
        this.actions[1] = new MenuTracker.GetAllAction("1", "Show all items");
        this.actions[2] = new EditAction("2", "Edit item");
        this.actions[3] = this.new DeleteAction("3", "Delete item");
        this.actions[4] = this.new FindByIdAction("4", "Find item by Id");
        this.actions[5] = this.new FindByNameAction("5", "Find items by name");
        this.actions[6] = this.new ExitAction("6", "Exit Program");
    }

    public int[] getMenuRange() {
        int[] result = new int[this.actions.length];
        for (int i = 0; i < this.actions.length; i++) {
            result[i] = i;
        }
        return result;
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

    /**
     * Add new request to the storage.
     */
    public class AddAction extends BaseAction {

        public AddAction(String key, String title) {
            super(key, title);
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
    }

    /**
     * Show all requests.
     */
    private class GetAllAction extends BaseAction {
        public GetAllAction(String key, String title) {
            super(key, title);
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
    }

    /**
     * Delete request from storage.
     */
    private class DeleteAction extends BaseAction {
        public DeleteAction(String key, String title) {
            super(key, title);
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
    }

    /**
     * Find request by ID.
     */
    private class FindByIdAction extends BaseAction {
        public FindByIdAction(String key, String title) {
            super(key, title);
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
    }

    /**
     * Find requests by name.
     */
    private class FindByNameAction extends BaseAction {
        public FindByNameAction(String key, String title) {
            super(key, title);
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
    }

    private class ExitAction extends BaseAction {
        public ExitAction(String key, String title) {
            super(key, title);
        }

        @Override
        public void execute(Input input, Tracker tracker) { }
    }
}

/**
 * Edit request.
 */
class EditAction extends BaseAction {
    public EditAction(String key, String title) {
        super(key, title);
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
}
