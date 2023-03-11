package e2.logic;

import e2.logic.cell.Cell;

import java.util.HashSet;
import java.util.Set;

public class HiddenGridImpl implements HiddenGrid {

    private final Grid grid;
    private final Set<Cell> hiddenCells = new HashSet<>();

    HiddenGridImpl(Grid grid) {
        this.grid = grid;
    }
    @Override
    public CellState getCellContent(Cell cell) {
        if (hiddenCells.contains(cell)) {
            return this.grid.getCellContent(cell);
        } else {
            return CellState.HIDDEN;
        }
    }

    @Override
    public CellState reveal(Cell cell) {
        this.hiddenCells.add(cell);
        return this.grid.getCellContent(cell);
    }
}
