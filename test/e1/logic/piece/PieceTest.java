package e1.logic.piece;

import e1.logic.position.Position;
import e1.logic.position.PositionFactoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

abstract class PieceTest {

    private static Piece piece;
    private static PieceFactory pieceFactory;
    private static Position INITIAL_POSITION =
            new PositionFactoryImpl().fromRowAndColumn(0,0);

    @BeforeEach
    void setUp() {
        pieceFactory = new PieceFactoryImpl();
    }

    @Test
    void testPieceInitiallyWithoutPosition() {
        assertEquals(Optional.empty(), piece.getPosition());
    }

    @Test
    void testMovePiece() {
        piece.setPosition(INITIAL_POSITION);
        assertEquals(Optional.of(INITIAL_POSITION), piece.getPosition());
    }

    static class PawnTest extends PieceTest {
        @Override
        @BeforeEach
        void setUp() {
            super.setUp();
            piece = pieceFactory.getPawn();
        }
    }

    static class KnightTest extends PieceTest {
        @Override
        @BeforeEach
        void setUp() {
            super.setUp();
            piece = pieceFactory.getKnight();
        }
    }
}