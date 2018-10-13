package ru.job4j.tracker;

import java.util.*;

/**
* Items storage and methods to work with items.
* @author Vladimir Mytnik (vova@myrnik.net).
* @version 0.1.
*/
public class Tracker {
    /**
    * items array.
    */
    private Item[] items = new Item[100];

    /**
    * Current pointer.
    */
    private int position = 0;

    /**
    * Generate rundom number.
    */
    private static final Random RN = new Random();

    /**
    * Add a new item to storage.
    * @param item - new item.
    * @return - new item object.
    */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
    * Replace single item by id.
    * @param id - item id.
    * @param item - item.
    */
    public void replace(String id, Item item) {
        for (int i = 0; i <= this.position; i++) {
            if (this.items[i] != null && this.items[i].getId().equals(id)) {
                item.setId(id);
                this.items[i] = item;
                break;
            }
        }
    }

    /**
    * Delete single item by id.
    * @param id - item id.
    */
    public void delete(String id) {
        int itemIndex = -1;
        for (int i = 0; i <= this.position; i++) {
            if (this.items[i].getId().equals(id)) {
                itemIndex = i;
                this.position--;
                break;
            }
        }
        if (itemIndex != -1) {
            System.arraycopy(this.items, itemIndex + 1, this.items, itemIndex, this.items.length - itemIndex - 1);
        }
    }

    /**
    * Get all tasks array.
    * @return - this.items array copy, without nulls.
    */
    public Item[] getAll() {
        Item[] result = new Item[this.position];
        System.arraycopy(this.items, 0, result, 0, position);
        return result;
    }

    /**
    * Find by item name.
    * @param key - item name.
    * @return - items array with required name.
    */
    public Item[] findByName(String key) {
        Item[] arrWithKey = new Item[this.position];
        int resultPosition  = 0;
        for (int i = 0; i < this.position; i++) {
            if (this.items[i] != null && this.items[i].getName().equals(key)) {
                arrWithKey[resultPosition++] = this.items[i];
            }
        }
        Item[] result = new Item[resultPosition];
        System.arraycopy(arrWithKey, 0, result, 0, resultPosition);
        return result;
    }

    /**
    * Find by item id.
    * @param id - item id.
    * @return - item required id.
    */
    public Item findById(String id) {
        Item result = null;
        for (int i = 0; i < this.position; i++) {
            if (this.items[i] != null && this.items[i].getId().equals(id)) {
                result = this.items[i];
                break;
            }
        }
        return result;
    }

    /**
     * Generate item unique key.
     * @return unique key.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
}