package e2.logic.cell;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {

    private static final int INITIAL_ROW = 1;
    private static final int INITIAL_COLUMN = 1;
    private Cell cell;
    @BeforeEach
    void setUp() {
        cell = new CellImpl(INITIAL_ROW, INITIAL_COLUMN);
    }

    @Test
    void testCreation() {
        assertEquals(INITIAL_ROW, cell.getRow());
        assertEquals(INITIAL_COLUMN, cell.getColumn());
    }

    @Test
    void testAdjacency() {
        var adjCell = new CellImpl(0, 0);
        assertTrue(cell.isAdjacencyTo(adjCell));
    }

    @Test
    void testNotAdjacency() {
        var notAdjCell = new CellImpl(3, 3);
        assertFalse(cell.isAdjacencyTo(notAdjCell));
    }
}