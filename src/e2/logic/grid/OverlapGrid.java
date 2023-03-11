package e2.logic.grid;

import e2.logic.grid.cell.Cell;

/**
 * Decorator Interface for grid,
 * that introduce hidden and flagged cells.
 */
public interface OverlapGrid extends Grid {

    /**
     * Reveal a cell.
     * @param cell to be revealed.
     */
    void reveal(Cell cell);

    /**
     * Reveal all cells.
     */
    void revealAll();

    /**
     * Reveal all bombs.
     */
    void revealAllBombs();

    /**
     * Flag a cell.
     * @param cell to be flagged.
     */
    void changeFlag(Cell cell);
}
