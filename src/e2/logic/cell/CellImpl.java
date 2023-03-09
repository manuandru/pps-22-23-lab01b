package e2.logic.cell;

public class CellImpl implements Cell {
    private final int row;
    private final int column;

    public CellImpl(int row, int column) {
        this.row = row;
        this.column = column;
    }

    @Override
    public int getRow() {
        return this.row;
    }

    @Override
    public int getColumn() {
        return this.column;
    }

    @Override
    public boolean isAdjacencyTo(Cell otherCell) {
        int x = this.row - otherCell.getRow();
        int y = this.column - otherCell.getColumn();
        return Math.abs(x) <= 1 && Math.abs(y) <= 1;
    }
}
