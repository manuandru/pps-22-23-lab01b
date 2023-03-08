package e1.logic.piece;

public interface PieceFactory {

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
