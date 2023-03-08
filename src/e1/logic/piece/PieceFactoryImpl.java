package e1.logic.piece;

import e1.logic.position.Position;

public class PieceFactoryImpl implements PieceFactory {
    @Override
    public PieceFactoryWithPosition withPosition(Position position) {
        return new PieceFactoryWithPositionImpl(position);
    }
}
