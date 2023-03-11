package e2.logic.grid;

import e2.logic.grid.cell.Cell;

/**
 * Decorator Interface for grid.
 */
public interface HiddenGrid extends Grid {

    void reveal(Cell cell);
}
