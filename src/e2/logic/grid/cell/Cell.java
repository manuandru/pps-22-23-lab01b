package e2.logic.grid.cell;

public interface Cell {

    /**
     *
     * @return the row of the cell.
     */
    int getRow();

    /**
     *
     * @return the column of the cell
     */
    int getColumn();

    boolean isAdjacencyTo(Cell otherCell);
}
