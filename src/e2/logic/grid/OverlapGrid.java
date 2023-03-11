package e2.logic.grid;

import e2.logic.grid.cell.Cell;

/**
 * Decorator Interface for grid.
 */
public interface OverlapGrid extends Grid {

    void reveal(Cell cell);

    void revealAllBombs();

    void changeFlag(Cell cell);

    void revealAll();
}
