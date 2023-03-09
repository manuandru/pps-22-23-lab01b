package e1.logic.piece.factory;

import e1.logic.piece.position.Position;

/**
 * Entry Point for PieceFactory.
 */
public interface PieceFactory {

    /**
     *
     * @return a factory of Piece with position set.
     */
    PieceFactoryWithPosition withPosition(Position position);
}
