package e1.logic.piece.factory;

import e1.logic.piece.Piece;

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
