package e2.logic.grid;

import e2.logic.grid.cell.Cell;
import e2.logic.grid.cell.CellState;

import java.util.HashSet;
import java.util.Set;

public class HiddenGridImpl implements HiddenGrid {

    private final Grid grid;
    private final Set<Cell> hiddenCells = new HashSet<>();

    public HiddenGridImpl(Grid grid) {
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
    public Set<Cell> getAllCells() {
        return this.grid.getAllCells();
    }

    @Override
    public void reveal(Cell cell) {
        this.hiddenCells.add(cell);
    }

    @Override
    public void revealAllBombs() {
        this.grid.getAllCells().stream()
                .filter(cell -> this.grid.getCellContent(cell).equals(CellState.BOMB))
                .forEach(this::reveal);
    }
}
