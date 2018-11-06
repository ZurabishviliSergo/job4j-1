package ru.job4j.search;

/**
 * Task class.
 *
 * @author Vladimir Mytnik (vova@mytnik.net).
 * @version 0.1.
 * @since 11/5/18
 */
public class Task {
    /**
     * Task description.
     */
    private String desc;
    /**
     * Task priority.
     */
    private int priority;

    /**
     * New task constructor.
     * @param desc new task description.
     * @param priority new task priority.
     */
    public Task(String desc, int priority) {
        this.desc = desc;
        this.priority = priority;
    }

    /**
     * Description getter.
     * @return task description
     */
    public String getDesc() {
        return desc;
    }
    /**
     * Priority getter.
     * @return task priority.
     */
    public int getPriority() {
        return priority;
    }
}