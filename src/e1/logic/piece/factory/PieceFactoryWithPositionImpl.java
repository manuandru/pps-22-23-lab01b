package e1.logic.piece.factory;

import e1.logic.piece.Piece;
import e1.logic.piece.PieceImpl;
import e1.logic.position.Position;

public class PieceFactoryWithPositionImpl implements PieceFactoryWithPosition {

    private final Position position;
    public PieceFactoryWithPositionImpl(Position position) {
        this.position = position;
    }


    @Override
    public Piece getPawn() {
        return new PieceImpl(position, (from, to) -> false);
    }

    @Override
    public Piece getKnight() {
        return new PieceImpl(position, (from, to) -> {
            int x = to.getRow()-from.getRow();
            int y = to.getColumn()-from.getColumn();
            return x!=0 && y!=0 && Math.abs(x)+Math.abs(y)==3;
        });
    }

}
