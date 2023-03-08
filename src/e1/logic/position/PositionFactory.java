package e1.logic.position;

public interface PositionFactory {

    /**
     *
     * @return a new Random Position
     */
    Position randomPositionWithBound(int bound);

    /**
     *
     * @param row for the position
     * @param column for the position
     * @return the position with row and column
     */
    Position fromRowAndColumn(int row, int column);
}
