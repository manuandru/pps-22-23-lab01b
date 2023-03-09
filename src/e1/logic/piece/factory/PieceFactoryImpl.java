package e1.logic.piece.factory;

import e1.logic.piece.position.Position;

public class PieceFactoryImpl implements PieceFactory {
    @Override
    public PieceFactoryWithPosition withPosition(Position position) {
        return new PieceFactoryWithPositionImpl(position);
    }
}
