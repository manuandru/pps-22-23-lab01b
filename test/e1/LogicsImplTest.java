package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.*;
class LogicsTest {

    private static final int BOARD_SIZE = 3;
    private Logics logic;

    @BeforeEach
    void setUp() {
        this.logic = new LogicsImpl(BOARD_SIZE);
    }

    @Test
    void testPawnIsExactlyOne() {
        assertEquals(1, countNumberOf(this.logic::hasPawn));
    }

    @Test
    void testKnightIsExactlyOne() {
        assertEquals(1, countNumberOf(this.logic::hasKnight));
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