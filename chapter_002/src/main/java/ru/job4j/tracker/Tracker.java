package ru.job4j.tracker;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Items storage and methods to work with items.
 * @author Vladimir Mytnik (vova@myrnik.net).
 * @version 0.1.
 */
public class Tracker {
    /**
     * items array.
     */
    private List<Item> items = new ArrayList<>();
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
        this.items.add(item);
        return item;
    }
    /**
     * Replace single item by id.
     * @param id - item id.
     * @param item - item.
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        item.setId(id);
        int replaceIdx = this.items.indexOf(item);
        if (replaceIdx != -1) {
            this.items.set(replaceIdx, item);
            result = true;
        }
        return result;
    }
    /**
     * Delete single item by id.
     * @param id - item id.
     * @return name of deleted item.
     */
    public boolean delete(String id) {
        return this.items.removeIf(item -> item.getId().equals(id));
    }
    /**
     * Get all tasks array.
     * @return - this.items array copy, without nulls.
     */
    public List<Item> getAll() {
        return this.items;
    }
    /**
     * Find by item name.
     * @param key - item name.
     * @return - items array with required name.
     */
    public List<Item> findByName(String key) {
//        List<Item> resultList = new ArrayList<>();
//        for (Item item : this.items) {
//            if (item.getName().equals(key)) {
//                resultList.add(item);
//            }
//        }
//        return resultList;
        return this.items.stream().filter(item -> item.getName().equals(key)).collect(Collectors.toList());
    }

    /**
     * Find by item id.
     * @param id - item id.
     * @return - item required id.
     */
    public Item findById(String id) {
//        Item result = null;
//        for (Item item : this.items) {
//            if (item.getId().equals(id)) {
//                result = item;
//                break;
//            }
//        }
//        return result;
        return this.items.stream().filter(item -> item.getId().equals(id)).findFirst().orElse(null);
    }

    /**
     * Generate item unique key.
     * @return unique key.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
}