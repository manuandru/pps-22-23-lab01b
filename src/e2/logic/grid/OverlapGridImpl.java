package e2.logic.grid;

import e2.logic.grid.cell.Cell;
import e2.logic.grid.cell.CellState;

import java.util.HashSet;
import java.util.Set;

public class OverlapGridImpl implements OverlapGrid {

    private final Grid grid;
    private final Set<Cell> revealedCells = new HashSet<>();
    private final Set<Cell> flaggedCells = new HashSet<>();

    public OverlapGridImpl(Grid grid) {
        this.grid = grid;
    }
    @Override
    public CellState getCellContent(Cell cell) {
        if (this.revealedCells.contains(cell)) {
            return this.grid.getCellContent(cell);
        }
        if (this.flaggedCells.contains(cell)) {
            return CellState.FLAG;
        }
        return CellState.HIDDEN;
    }

    @Override
    public Set<Cell> getAllCells() {
        return this.grid.getAllCells();
    }

    @Override
    public int countOfAdjacentBombs(Cell cell) {
        return this.grid.countOfAdjacentBombs(cell);
    }

    @Override
    public void reveal(Cell cell) {
        this.revealedCells.add(cell);
        if (this.countOfAdjacentBombs(cell) == 0) {
            for (var c : this.getAllCells()) {
                if (c.isAdjacencyTo(cell)
                        && !this.revealedCells.contains(c)) {
                    this.reveal(c);
                }
            }
        }
    }

    @Override
    public void revealAllBombs() {
        this.grid.getAllCells().stream()
                .filter(cell -> this.grid.getCellContent(cell).equals(CellState.BOMB))
                .forEach(this::reveal);
    }

    @Override
    public void revealAll() {
        this.grid.getAllCells().forEach(this::reveal);
    }

    @Override
    public void changeFlag(Cell cell) {
        if (this.flaggedCells.contains(cell)) {
            this.flaggedCells.remove(cell);
        } else {
            this.flaggedCells.add(cell);
        }
    }

}
