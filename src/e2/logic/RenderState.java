package e2.logic;

public enum RenderState {
    BOMB, COUNTER, FLAG, HIDDEN;

    private int counter;
    public RenderState setCounter(int counter) {
        this.counter = counter;
        return this;
    }

    public int getCounter() {
        return this.counter;
    }
}
