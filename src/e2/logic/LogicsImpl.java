package e2.logic;

import e2.gui.RenderStatus;
import e2.logic.grid.cell.Cell;
import e2.logic.grid.cell.CellImpl;
import e2.logic.grid.cell.CellContent;
import e2.logic.grid.GridImpl;
import e2.logic.grid.OverlapGrid;
import e2.logic.grid.OverlapGridImpl;

public class LogicsImpl implements Logics {

    private final OverlapGrid grid;
    private final int size;
    private final int bombCount;
    public LogicsImpl(int size, int bombs) {
        this.size = size;
        this.bombCount = bombs;
        this.grid = new OverlapGridImpl(new GridImpl(size, bombs));
    }

    @Override
    public boolean checkIfContainsBomb(int row, int column) {
        Cell target = new CellImpl(row, column);
        this.grid.reveal(target);
        return this.grid.getCellContent(target).equals(CellContent.BOMB);
    }

    @Override
    public RenderStatus getStatus(int row, int column) {
        var cell = new CellImpl(row, column);
        return switch (this.grid.getCellContent(cell)) {
            case BOMB -> RenderStatus.BOMB;
            case EMPTY -> RenderStatus.COUNTER.setCounter(this.grid.countOfAdjacentBombs(cell));
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
    public void changeFlag(int row, int column) {
        this.grid.changeFlag(new CellImpl(row, column));
    }

    @Override
    public boolean won() {
        var countOfRevealed = this.grid.getAllCells().stream()
                .map(this.grid::getCellContent)
                .filter(CellContent.EMPTY::equals)
                .count();
        var cellToReveal = size*size - bombCount;
        return cellToReveal == countOfRevealed;
    }
}
