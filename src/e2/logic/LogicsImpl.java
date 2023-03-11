package e2.logic;

import e2.gui.RenderStatus;
import e2.logic.grid.cell.Cell;
import e2.logic.grid.cell.CellImpl;
import e2.logic.grid.cell.CellState;
import e2.logic.grid.GridImpl;
import e2.logic.grid.OverlapGrid;
import e2.logic.grid.OverlapGridImpl;

public class LogicsImpl implements Logics {

    private final OverlapGrid grid;
    public LogicsImpl(int size, int bombs) {
        this.grid = new OverlapGridImpl(new GridImpl(size, bombs));
    }

    @Override
    public boolean checkIfContainsBomb(int x, int y) {
        Cell target = new CellImpl(x, y);
        this.grid.reveal(target);
        return this.grid.getCellContent(target).equals(CellState.BOMB);
    }

    @Override
    public RenderStatus getStatus(int x, int y) {
        var content = this.grid.getCellContent(new CellImpl(x, y));
        return switch (content) {
            case BOMB -> RenderStatus.BOMB;
            case EMPTY -> RenderStatus.COUNTER.setCounter(0);
            case HIDDEN -> RenderStatus.HIDDEN;
            case FLAG -> RenderStatus.FLAG;
        };
    }

    @Override
    public void revealAllBombs() {
        this.grid.revealAllBombs();
    }

    @Override
    public void revealAll() {
        this.grid.revealAll();
    }

    @Override
    public void changeFlag(int x, int y) {
        this.grid.changeFlag(new CellImpl(x, y));
    }
}
