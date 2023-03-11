package e2.logic;

import e2.gui.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GridTest {

    private final static int GRID_SIZE = 5;
    private final static int BOMB_COUNT = 5;
    private Grid grid;
    @BeforeEach
    void setUp() {
        grid = new GridImpl(GRID_SIZE, BOMB_COUNT);
    }

    @Test
    void testBombsArePut() {
        var allPositions = new ArrayList<Pair<Integer, Integer>>();
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                allPositions.add(new Pair<>(i, j));
            }
        }
        var countOfBomb = allPositions.stream()
                .map(p -> grid.isBomb(p.getX(), p.getY()))
                .filter(Boolean::booleanValue)
                .count();
        assertEquals(BOMB_COUNT, countOfBomb);
    }
}