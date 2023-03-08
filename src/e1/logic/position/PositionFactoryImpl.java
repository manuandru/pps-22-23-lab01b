package e1.logic.position;

import java.util.Objects;
import java.util.Random;

public class PositionFactoryImpl implements PositionFactory {
    private final Random random = new Random();

    @Override
    public Position randomPositionWithBound(int bound) {
        return new SimplePosition(this.random.nextInt(bound), this.random.nextInt(bound));
    }

    @Override
    public Position fromRowAndColumn(int row, int column) {
        return new SimplePosition(row, column);
    }

    private static class SimplePosition implements Position {
        private final int row;
        private final int column;

        SimplePosition(int row, int column) {
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
            SimplePosition that = (SimplePosition) o;
            return row == that.row && column == that.column;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, column);
        }
    }
}
