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


        public static final Pair<Integer, Integer> KNIGHT_POSITION = new Pair<>(0, 0);
        public static final Pair<Integer, Integer> PAWN_POSITION = new Pair<>(1, 2);

        @BeforeEach
        void setUp() {
            logic = new LogicsImpl(PAWN_POSITION, KNIGHT_POSITION, BOARD_SIZE);
        }

        @Test
        void testPawnCorrectlyAdded() {
            assertTrue(logic.hasPawn(PAWN_POSITION.getX(), PAWN_POSITION.getY()));
            assertFalse(logic.hasPawn(KNIGHT_POSITION.getX(), KNIGHT_POSITION.getY()));
        }

        @Test
        void testKnightCorrectlyAdded() {
            assertTrue(logic.hasKnight(KNIGHT_POSITION.getX(), KNIGHT_POSITION.getY()));
            assertFalse(logic.hasKnight(PAWN_POSITION.getX(), PAWN_POSITION.getY()));
        }

        @Test
        void testKnightCannotMoveOutOfBoard() {
            var illegalPosition = new Pair<>(-1, -1);
            assertThrows(
                    IndexOutOfBoundsException.class,
                    () -> logic.hit(illegalPosition.getX(), illegalPosition.getY())
            );
        }

        @Test
        void testKnightDoNotHitPawn() {
            var emptyPosition = new Pair<>(0, 1);
            assertFalse(logic.hit(emptyPosition.getX(), emptyPosition.getY()));
        }

        @Test
        void testKnightHitPawn() {
            assertTrue(logic.hit(PAWN_POSITION.getX(), PAWN_POSITION.getY()));
        }
    }
}