package e2.logic;

import e2.logic.grid.cell.Cell;
import e2.logic.grid.cell.CellImpl;
import e2.logic.grid.cell.CellState;
import e2.logic.grid.Grid;
import e2.logic.grid.GridImpl;
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
        var countOfBomb = grid.getAllCells().stream()
                .map(grid::getCellContent)
                .filter(CellState.BOMB::equals)
                .count();
        assertEquals(BOMB_COUNT, countOfBomb);
    }

}