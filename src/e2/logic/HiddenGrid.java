package e2.logic;

import e2.logic.cell.Cell;

/**
 * Decorator Interface for grid.
 */
public interface HiddenGrid extends Grid {

    void reveal(Cell cell);
}
