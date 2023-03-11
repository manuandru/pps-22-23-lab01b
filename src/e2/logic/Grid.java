package e2.logic;

import e2.logic.cell.Cell;

/**
 * Grid of cell that can contains bomb or not.
 */
public interface Grid {
    CellState getCellContent(Cell cell);

}
