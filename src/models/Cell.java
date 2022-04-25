package models;

public class Cell {
    private boolean cleared = false;
    private Rune rune;

    public boolean isCleared() {
        return cleared;
    }

    public void setCleared(boolean cleared) {
        this.cleared = cleared;
    }

    public Rune getRune() {
        return rune;
    }

    public void setRune(Rune rune) {
        this.rune = rune;
    }
}
