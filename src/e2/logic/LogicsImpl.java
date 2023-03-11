package e2.logic;

public class LogicsImpl implements Logics {

    private final Grid grid;
    public LogicsImpl(int size, int bombs) {
        grid = new GridImpl(size, bombs);
    }

    @Override
    public boolean isBomb(int x, int y) {
        return grid.isBomb(x, y);
    }

    @Override
    public RenderState getStatus(int x, int y) {
        if (isBomb(x,y)) {
            return RenderState.BOMB;
        } else {
            return RenderState.HIDDEN;
        }
    }
}
