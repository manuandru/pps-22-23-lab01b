package e1.logic.piece.factory;

import e1.logic.position.Position;

/**
 * StepBuilder interface.
 */
public interface PieceFactory {

    /**
     *
     * @return a factory of Piece with position set.
     */
    PieceFactoryWithPosition withPosition(Position position);
}
