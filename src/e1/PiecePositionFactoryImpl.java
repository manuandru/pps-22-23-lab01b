package e1;

import java.util.Objects;
import java.util.Random;

public class PiecePositionFactoryImpl implements PiecePositionFactory {
    private final Random random = new Random();

    @Override
    public PiecePosition randomPositionWithBound(int bound) {
        return new SimplePiecePosition(this.random.nextInt(bound), this.random.nextInt(bound));
    }

    @Override
    public PiecePosition fromRowAndColumn(int row, int column) {
        return new SimplePiecePosition(row, column);
    }

    private static class SimplePiecePosition implements PiecePosition {
        private final int row;
        private final int column;

        SimplePiecePosition(int row, int column) {
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
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            SimplePiecePosition that = (SimplePiecePosition) o;
            return row == that.row && column == that.column;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, column);
        }
    }
}
