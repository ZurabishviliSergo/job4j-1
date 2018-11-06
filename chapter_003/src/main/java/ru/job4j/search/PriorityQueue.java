package ru.job4j.search;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Tasks list.
 *
 * @author Vladimir Mytnik (vova@mytnik.net).
 * @version 0.1.
 * @since 11/5/18
 */
public class PriorityQueue {
    /**
     * All tasks.
     */
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Add task to correct position.
     * @param task new task to add.
     */
    public void put(Task task) {
        if (tasks.size() == 0) {
            tasks.add(task);
        } else {
            ListIterator<Task> itr = tasks.listIterator();
            while (itr.hasNext()) {
                if (itr.next().getPriority() > task.getPriority()) {
                    tasks.add(itr.previousIndex(), task);
                    break;
                }
            }
        }
    }

    /**
     * Take first task from the list.
     * @return highest priority task.
     */
    public Task take() {
        return this.tasks.poll();
    }
}
