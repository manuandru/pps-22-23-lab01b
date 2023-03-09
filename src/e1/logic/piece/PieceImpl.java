package e1.logic.piece;

import e1.logic.piece.position.Position;

public class PieceImpl implements Piece {

    private Position position;
    private final MovementStrategy strategy;

    public PieceImpl(Position position, MovementStrategy strategy) {
        this.position = position;
        this.strategy = strategy;
    }

    @Override
    public Position getPosition() {
        return this.position;
    }

    @Override
    public void moveTo(Position newPosition) {
        if (strategy.canMove(this.position, newPosition)) {
            this.position = newPosition;
        }
    }
}
