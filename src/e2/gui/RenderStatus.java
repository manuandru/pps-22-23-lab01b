package e2.gui;

public enum RenderStatus {
    BOMB, COUNTER, FLAG, HIDDEN;

    private int counter;
    public RenderStatus setCounter(int counter) {
        this.counter = counter;
        return this;
    }

    public int getCounter() {
        return this.counter;
    }
}
