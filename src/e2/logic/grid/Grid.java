package e2.logic.grid;

import e2.logic.grid.cell.Cell;
import e2.logic.grid.cell.CellState;

import java.util.Set;

/**
 * Grid of cell that can contains bomb or not.
 */
public interface Grid {

    /**
     *
     * @param cell to get the Content.
     * @return the content of the cell.
     */
    CellState getCellContent(Cell cell);

    /**
     *
     * @return all cells of the grid.
     */
    Set<Cell> getAllCells();
}
