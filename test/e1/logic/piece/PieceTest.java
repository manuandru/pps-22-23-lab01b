package e1.logic.piece;

import e1.logic.piece.factory.PieceFactory;
import e1.logic.piece.factory.PieceFactoryImpl;
import e1.logic.position.Position;
import e1.logic.position.PositionFactory;
import e1.logic.position.PositionFactoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

abstract class PieceTest {

    private static Piece piece;
    private static PieceFactory pieceFactory;

    private static PositionFactory positionFactory = new PositionFactoryImpl();
    private static Position INITIAL_POSITION =
            positionFactory.fromRowAndColumn(0,0);

    @BeforeEach
    void setUp() {
        pieceFactory = new PieceFactoryImpl();
    }

    @Test
    void testPositioningPiece() {
        assertEquals(INITIAL_POSITION, piece.getPosition());
    }

    static class PawnTest extends PieceTest {
        @Override
        @BeforeEach
        void setUp() {
            super.setUp();
            piece = pieceFactory
                    .withPosition(INITIAL_POSITION)
                    .getPawn();
        }

        @Test
        void testPawnCannotMove() {
            var newPosition = positionFactory.fromRowAndColumn(1,1);
            piece.moveTo(newPosition);
            assertEquals(INITIAL_POSITION, piece.getPosition());
        }
    }

    static class KnightTest extends PieceTest {
        @Override
        @BeforeEach
        void setUp() {
            super.setUp();
            piece = pieceFactory
                    .withPosition(INITIAL_POSITION)
                    .getKnight();
        }

        @Test
        void testKnightCanMove() {
            var newLegalPosition = positionFactory.fromRowAndColumn(2,1);
            piece.moveTo(newLegalPosition);
            assertEquals(newLegalPosition, piece.getPosition());
        }

        @Test
        void testKnightBadMove() {
            var newIllegalPosition = positionFactory.fromRowAndColumn(1,1);
            piece.moveTo(newIllegalPosition);
            assertEquals(INITIAL_POSITION, piece.getPosition());
        }
    }
}