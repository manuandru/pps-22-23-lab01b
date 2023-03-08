package e1;

public interface PiecePositionFactory {

    /**
     *
     * @return a new Random Position
     */
    PiecePosition randomPositionWithBound(int bound);

    /**
     *
     * @param row for the position
     * @param column for the position
     * @return the position with row and column
     */
    PiecePosition fromRowAndColumn(int row, int column);
}
