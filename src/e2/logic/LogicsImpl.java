package e2.logic;

import e2.gui.RenderStatus;
import e2.logic.grid.cell.Cell;
import e2.logic.grid.cell.CellImpl;
import e2.logic.grid.cell.CellState;
import e2.logic.grid.GridImpl;
import e2.logic.grid.HiddenGrid;
import e2.logic.grid.HiddenGridImpl;

public class LogicsImpl implements Logics {

    private final HiddenGrid gridWithHidden;
    public LogicsImpl(int size, int bombs) {
        gridWithHidden = new HiddenGridImpl(new GridImpl(size, bombs));

    }

    @Override
    public boolean checkIfContainsBomb(int x, int y) {
        Cell target = new CellImpl(x, y);
        gridWithHidden.reveal(target);
        return gridWithHidden.getCellContent(target).equals(CellState.BOMB);
    }

    @Override
    public RenderStatus getStatus(int x, int y) {
        var content = gridWithHidden.getCellContent(new CellImpl(x, y));
        return switch (content) {
            case BOMB -> RenderStatus.BOMB;
            case EMPTY -> RenderStatus.COUNTER.setCounter(0);
            case HIDDEN -> RenderStatus.HIDDEN;
        };
    }
}
