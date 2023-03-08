package e1.logic.piece;

public interface PieceFactoryWithPosition {

    /**
     *
     * @return a Pawn.
     */
    Piece getPawn();

    /**
     *
     * @return a Knight.
     */
    Piece getKnight();
}
