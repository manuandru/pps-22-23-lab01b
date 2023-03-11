package e2.logic;

import e2.logic.cell.Cell;
import e2.logic.cell.CellImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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
        var allPositions = new ArrayList<Cell>();
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                allPositions.add(new CellImpl(i,j));
            }
        }
        var countOfBomb = allPositions.stream()
                .map(c -> grid.getCellContent(c))
                .filter(CellState.BOMB::equals)
                .count();
        assertEquals(BOMB_COUNT, countOfBomb);
    }
}