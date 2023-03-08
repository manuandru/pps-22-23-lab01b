package e1.logic.piece;

import e1.logic.position.Position;

import java.util.Optional;

public class PieceFactoryImpl implements PieceFactory {
    @Override
    public Piece getPawn() {
        return new Piece() {
            private Position position;
            @Override
            public Optional<Position> getPosition() {
                return Optional.ofNullable(this.position);
            }

            @Override
            public void setPosition(Position position) {
                this.position = position;
            }
        };
    }

    @Override
    public Piece getKnight() {
        return new Piece() {
            private Position position;
            @Override
            public Optional<Position> getPosition() {
                return Optional.ofNullable(this.position);
            }

            @Override
            public void setPosition(Position position) {
                this.position = position;
            }
        };
    }
}
