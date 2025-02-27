package e1.logic.piece;

import e1.logic.piece.position.Position;

/**
 * Movement Strategy for piece.
 */
public interface MovementStrategy {
    boolean canMove(Position from, Position to);
}
