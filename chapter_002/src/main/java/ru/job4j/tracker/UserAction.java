package ru.job4j.tracker;

public interface UserAction {
    String key();
    void execute(Input input, Tracker tracker);
    String title();
}
