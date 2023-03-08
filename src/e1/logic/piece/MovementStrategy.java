package e1.logic.piece;

import e1.logic.position.Position;

/**
 * Movement Strategy for piece.
 */
interface MovementStrategy {
    boolean canMove(Position from, Position to);
}
