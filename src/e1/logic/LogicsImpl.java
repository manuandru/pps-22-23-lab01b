package e1.logic;

import e1.logic.piece.Piece;
import e1.logic.piece.factory.PieceFactoryImpl;
import e1.logic.piece.factory.PieceFactoryWithPositionImpl;
import e1.logic.piece.position.Position;
import e1.logic.piece.position.PositionFactory;
import e1.logic.piece.position.PositionFactoryImpl;

public class LogicsImpl implements Logics {

	private final PositionFactory positionFactory = new PositionFactoryImpl();
	private final Piece pawn;
	private final Piece knight;
	private final int size;

	public LogicsImpl(Position pawnPosition, Position knightPosition, int size) {
		this.size = size;
		this.pawn = new PieceFactoryWithPositionImpl(pawnPosition).getPawn();
		this.knight = new PieceFactoryWithPositionImpl(knightPosition).getKnight();
	}

	public LogicsImpl(int size){
    	this.size = size;
		var pieceFactory = new PieceFactoryImpl();
		this.pawn = pieceFactory
				.withPosition(this.randomEmptyPosition())
				.getPawn();
        this.knight = pieceFactory
				.withPosition(this.randomEmptyPosition())
				.getKnight();
    }
    
	private final Position randomEmptyPosition() {
		Position pos = positionFactory.randomPositionWithBound(size);
    	// the recursive call below prevents clash with an existing pawn
    	return this.pawn!=null && this.pawn.getPosition().equals(pos) ? randomEmptyPosition() : pos;
    }
    
	@Override
	public boolean hit(int row, int col) {
		if (row<0 || col<0 || row >= this.size || col >= this.size) {
			throw new IndexOutOfBoundsException();
		}
		var newPosition = positionFactory.fromRowAndColumn(row, col);
		this.knight.moveTo(newPosition);
		return this.pawn.getPosition().equals(this.knight.getPosition());
	}

	@Override
	public boolean hasKnight(int row, int col) {
		return this.knight.getPosition().equals(positionFactory.fromRowAndColumn(row, col));
	}

	@Override
	public boolean hasPawn(int row, int col) {
		return this.pawn.getPosition().equals(positionFactory.fromRowAndColumn(row, col));
	}
}
