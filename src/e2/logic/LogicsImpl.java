package e2.logic;

import e2.logic.cell.CellImpl;

public class LogicsImpl implements Logics {

    private final HiddenGrid gridWithHidden;
    public LogicsImpl(int size, int bombs) {
        gridWithHidden = new HiddenGridImpl(new GridImpl(size, bombs));

    }

    @Override
    public boolean checkIfContainsBomb(int x, int y) {
        return gridWithHidden.getCellContent(new CellImpl(x, y)).equals(CellState.BOMB);
    }

    @Override
    public RenderState getStatus(int x, int y) {
        var content = gridWithHidden.getCellContent(new CellImpl(x, y));
        return switch (content) {
            case BOMB -> RenderState.BOMB;
            case EMPTY -> RenderState.COUNTER.setCounter(0);
            case HIDDEN -> RenderState.HIDDEN;
        };
    }
}
