package ru.job4j.chess;

public class Cell {
    private final int x;
    private final int y;
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public boolean equals(Cell cell) {
        return cell.getX() == this.x && cell.getY() == this.y;
    }
}
