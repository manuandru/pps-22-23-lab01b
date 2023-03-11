package e2.logic.grid;

import e2.logic.grid.cell.Cell;
import e2.logic.grid.cell.CellState;

import java.util.Set;

/**
 * Grid of cell that can contains bomb or not.
 */
public interface Grid {
    CellState getCellContent(Cell cell);

    Set<Cell> getAllCells();
}
