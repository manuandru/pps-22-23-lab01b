package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
        List<Pair<Integer, Integer>> allPositions = new ArrayList<>();
        for (var i = 0; i < BOARD_SIZE; i++) {
            for (var j = 0; j < BOARD_SIZE; j++) {
                allPositions.add(new Pair<>(i, j));
            }
        }
        assertEquals(1, allPositions.stream()
                .map(p -> this.logic.hasPawn(p.getX(), p.getY()))
                .filter(Boolean::booleanValue)
                .count()
        );
    }

    @Test
    void testKnightIsExactlyOne() {
        List<Pair<Integer, Integer>> allPositions = new ArrayList<>();
        for (var i = 0; i < BOARD_SIZE; i++) {
            for (var j = 0; j < BOARD_SIZE; j++) {
                allPositions.add(new Pair<>(i, j));
            }
        }
        assertEquals(1, allPositions.stream()
                .map(p -> this.logic.hasKnight(p.getX(), p.getY()))
                .filter(Boolean::booleanValue)
                .count()
        );
    }
}