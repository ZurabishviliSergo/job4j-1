package ru.job4j.tracker;

public class StubInput implements Input {

    private final String[] value;

    private int position;

    public StubInput(final String[] value) {
        this.value = value;
    }

    @Override
    public String ask(String question) {
        return this.value[this.position++];
    }

    @Override
    public int ask(String question, int[] range) {
        int key =  Integer.valueOf(this.value[position++]);
        boolean exist  = false;
        for (int el : range) {
            if (el == key) {
                exist = true;
            }
        }
        if (!exist) { throw new MenuOutException("Out of menu range."); }
        return key;
    }
}