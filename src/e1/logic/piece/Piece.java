package e1.logic.piece;

import e1.logic.position.Position;

import java.util.Optional;

/**
 * A Piece for chess.
 */
interface Piece {

    /**
     *
     * @return the position of the piece
     */
    Position getPosition();

    /**
     *
     * @param position to set.
     */
    void moveTo(Position position);
}
