package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    private final Tracker tracker = new Tracker();

    private final PrintStream stdout = System.out;

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    private final String userMenu = new StringBuilder()
            .append("Menu.")
            .append(System.lineSeparator())
            .append("0. Add new Item")
            .append(System.lineSeparator())
            .append("1. Show all items")
            .append(System.lineSeparator())
            .append("2. Edit item")
            .append(System.lineSeparator())
            .append("3. Delete item")
            .append(System.lineSeparator())
            .append("4. Find item by Id")
            .append(System.lineSeparator())
            .append("5. Find items by name")
            .append(System.lineSeparator())
            .append("6. Exit Program")
            .append(System.lineSeparator())
            .toString();

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll().get(0).getName(), is("test name"));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenUserAddAndDeleteOneItemThenTrackerNotHaveAnyItems() {
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll().size(), is(0));
    }

    @Test
    public void whenAddTwoItemsThenShowAllToOut() {
        Item item = tracker.add(new Item("test name", "desc"));
        Item item2 = tracker.add(new Item("test2 name", "desc2"));
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(this.out.toByteArray()), is(
                new StringBuilder()
                        .append(this.userMenu)
                        .append("------------ Show all requests --------------")
                        .append(System.lineSeparator())
                        .append(item.toString())
                        .append(System.lineSeparator())
                        .append(item2.toString())
                        .append(System.lineSeparator())
                        .append("------------ Total requests : 2 -----------")
                        .append(System.lineSeparator())
                        .append(this.userMenu)
                        .toString()
                )
        );
    }

    @Test
    public void whenFindItemByIdThenShowThenToOut() {
        Item item2 = tracker.add(new Item("test2 name", "desc2"));
        Input input = new StubInput(new String[]{"4", item2.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(this.out.toByteArray()), is(
                new StringBuilder()
                        .append(this.userMenu)
                        .append("------------ Find request by ID --------------")
                        .append(System.lineSeparator())
                        .append(item2.toString())
                        .append(System.lineSeparator())
                        .append("------------ Done -----------")
                        .append(System.lineSeparator())
                        .append(this.userMenu)
                        .toString()
                )
        );
    }

    @Test
    public void whenNotFindItemByIdThenShowMessageToOut() {
        String wrongId = "000";
        Input input = new StubInput(new String[]{"4", wrongId, "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(this.out.toByteArray()), is(
                new StringBuilder()
                        .append(this.userMenu)
                        .append("------------ Find request by ID --------------")
                        .append(System.lineSeparator())
                        .append("Can't find item with ID ")
                        .append(wrongId)
                        .append(System.lineSeparator())
                        .append("------------ Done -----------")
                        .append(System.lineSeparator())
                        .append(this.userMenu)
                        .toString()
                )
        );
    }

    @Test
    public void whenFindItemByNameThenShowThenToOut() {
        Item item2 = tracker.add(new Item("test2 name", "desc2"));
        Input input = new StubInput(new String[]{"5", item2.getName(), "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(this.out.toByteArray()), is(
                new StringBuilder()
                        .append(this.userMenu)
                        .append("------------ Find requests by name --------------")
                        .append(System.lineSeparator())
                        .append(item2.toString())
                        .append(System.lineSeparator())
                        .append("------------ Total results: 1 -----------")
                        .append(System.lineSeparator())
                        .append(this.userMenu)
                        .toString()
                )
        );
    }

    @Test
    public void whenNotFindItemByNameThenShowMessageToOut() {
        String wrongName = "TST";
        Input input = new StubInput(new String[]{"5", wrongName, "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(this.out.toByteArray()), is(
                new StringBuilder()
                        .append(this.userMenu)
                        .append("------------ Find requests by name --------------")
                        .append(System.lineSeparator())
                        .append("Can't find requests with name ")
                        .append(wrongName)
                        .append(System.lineSeparator())
                        .append("------------ Total results: 0 -----------")
                        .append(System.lineSeparator())
                        .append(this.userMenu)
                        .toString()
                )
        );
    }
}