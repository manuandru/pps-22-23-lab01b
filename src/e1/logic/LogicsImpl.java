package e1.logic;

import e1.logic.position.Position;
import e1.logic.position.PositionFactory;
import e1.logic.position.PositionFactoryImpl;

public class LogicsImpl implements Logics {

	private final PositionFactory positionFactory = new PositionFactoryImpl();
	private final Position pawn;
	private Position knight;
	private final int size;

	public LogicsImpl(Position pawn, Position knight, int size) {
		this.size = size;
		this.pawn = pawn;
		this.knight = knight;
	}

	public LogicsImpl(int size){
    	this.size = size;
        this.pawn = this.randomEmptyPosition();
        this.knight = this.randomEmptyPosition();	
    }
    
	private final Position randomEmptyPosition() {
		Position pos = positionFactory.randomPositionWithBound(size);
    	// the recursive call below prevents clash with an existing pawn
    	return this.pawn!=null && this.pawn.equals(pos) ? randomEmptyPosition() : pos;
    }
    
	@Override
	public boolean hit(int row, int col) {
		if (row<0 || col<0 || row >= this.size || col >= this.size) {
			throw new IndexOutOfBoundsException();
		}
		// Below a compact way to express allowed moves for the knight
		int x = row-this.knight.getRow();
		int y = col-this.knight.getColumn();
		if (x!=0 && y!=0 && Math.abs(x)+Math.abs(y)==3) {
			this.knight = positionFactory.fromRowAndColumn(row, col);
			return this.pawn.equals(this.knight);
		}
		return false;
	}

	@Override
	public boolean hasKnight(int row, int col) {
		return this.knight.equals(positionFactory.fromRowAndColumn(row, col));
	}

	@Override
	public boolean hasPawn(int row, int col) {
		return this.pawn.equals(positionFactory.fromRowAndColumn(row, col));
	}
}
