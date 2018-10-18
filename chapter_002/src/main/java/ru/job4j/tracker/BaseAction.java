package ru.job4j.tracker;

public abstract class BaseAction implements UserAction {
    private final String key;
    private final String title;

    protected BaseAction(String key, String title) {
        this.key = key;
        this.title = title;
    }

    @Override
    public String key() {
        return this.key;
    }

    @Override
    public String title() {
        return String.format("%s. %s", this.key, this.title);
    }
}
