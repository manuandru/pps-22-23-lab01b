package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.*;
class LogicsTest {
    private static final int BOARD_SIZE = 3;
    private static Logics logic;

    static class NormalBehaviourTest {

        @BeforeEach
        void setUp() {
            logic = new LogicsImpl(BOARD_SIZE);
        }

        @Test
        void testPawnIsExactlyOne() {
            assertEquals(1, countNumberOf(logic::hasPawn));
        }

        @Test
        void testKnightIsExactlyOne() {
            assertEquals(1, countNumberOf(logic::hasKnight));
        }

        private long countNumberOf(BiFunction<Integer, Integer, Boolean> chessType) {
            List<Pair<Integer, Integer>> allPositions = new ArrayList<>();
            for (var i = 0; i < BOARD_SIZE; i++) {
                for (var j = 0; j < BOARD_SIZE; j++) {
                    allPositions.add(new Pair<>(i, j));
                }
            }
            return allPositions.stream()
                    .map(p -> chessType.apply(p.getX(), p.getY()))
                    .filter(Boolean::booleanValue)
                    .count();
        }
    }

    static class BasicLogicTest {

        private static final PiecePositionFactory factory = new PiecePositionFactoryImpl();
        private static final PiecePosition KNIGHT_POSITION = factory.fromRowAndColumn(0, 0);
        private static final PiecePosition PAWN_POSITION = factory.fromRowAndColumn(1, 2);
        private static final PiecePosition EMPTY_POSITION = factory.fromRowAndColumn(1,1);

        @BeforeEach
        void setUp() {
            logic = new LogicsImpl(PAWN_POSITION, KNIGHT_POSITION, BOARD_SIZE);
        }

        @Test
        void testPawnCorrectlyAdded() {
            assertTrue(logic.hasPawn(PAWN_POSITION.getRow(), PAWN_POSITION.getColumn()));
            assertFalse(logic.hasPawn(EMPTY_POSITION.getRow(), EMPTY_POSITION.getColumn()));
        }

        @Test
        void testKnightCorrectlyAdded() {
            assertTrue(logic.hasKnight(KNIGHT_POSITION.getRow(), KNIGHT_POSITION.getColumn()));
            assertFalse(logic.hasKnight(EMPTY_POSITION.getRow(), EMPTY_POSITION.getColumn()));
        }

        @Test
        void testKnightCannotMoveOutOfBoard() {
            var illegalPosition = factory.fromRowAndColumn(-1, -1);
            assertThrows(
                    IndexOutOfBoundsException.class,
                    () -> logic.hit(illegalPosition.getRow(), illegalPosition.getColumn())
            );
        }

        @Test
        void testKnightDoesNotHitPawn() {
            assertFalse(logic.hit(EMPTY_POSITION.getRow(), EMPTY_POSITION.getColumn()));
        }

        @Test
        void testKnightHitPawn() {
            assertTrue(logic.hit(PAWN_POSITION.getRow(), PAWN_POSITION.getColumn()));
        }
    }
}