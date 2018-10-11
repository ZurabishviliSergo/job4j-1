package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
* Tracker class tests.
* @author Vladimir Mytnik (vova@mytnik.net).
* @version 0.1.
*/
public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.getAll()[0], is(item));
    }
 
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2", "testDescription2", 1234L);
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }
    @Test
    public void whenDeleteSingleItemThenTrackerEmpty() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        tracker.delete(tracker.getAll()[0].getId());
        assertThat(tracker.getAll().length, is(0));

    }
    @Test
    public void whenAddTwoItemsThenGetAllReturn2LengthArray() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        Item item2 = new Item("test2", "testDescription2", 1234L);
        tracker.add(item);
        tracker.add(item2);
        assertThat(tracker.getAll().length, is(2));

    }
    @Test
    public void whenAddThreeItemsAndTwoWithSameNameFindByNameReturnTwoItems() {
        Tracker tracker = new Tracker();
        Item item = new Item("test", "testDescription1", 123L);
        Item item2 = new Item("test2", "testDescription2", 1234L);
        Item item3 = new Item("test", "testDescription3", 12345L);
        tracker.add(item);
        tracker.add(item2);
        tracker.add(item3);

        assertThat(tracker.findByName("test").length, is(2));

    }
    @Test
    public void whenAddTwoItemsAndFindByIgThenGetItemName() {
        Tracker tracker = new Tracker();
        Item item = new Item("test", "testDescription1", 123L);
        Item item2 = new Item("test2", "testDescription2", 1234L);
        Item item3 = new Item("test3", "testDescription3", 12345L);
        tracker.add(item);
        tracker.add(item2);
        tracker.add(item3);
        String itemId = item3.getId();
        assertThat(tracker.findById(itemId).getName(), is("test3"));

    }
}

