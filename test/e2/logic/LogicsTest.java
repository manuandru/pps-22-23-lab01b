package e2.logic;

import e2.gui.Pair;
import e2.gui.RenderStatus;
import e2.logic.grid.cell.CellImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LogicsTest {

    private final static int BOARD_SIZE = 5;
    private final static int BOMBS_COUNT = 5;
    private Logics logics;
    @BeforeEach
    void setUp() {
        logics = new LogicsImpl(BOARD_SIZE, BOMBS_COUNT);
    }

    @Test
    void testInitiallyAllHidden() {
        getAllPositions().forEach(p -> {
            assertEquals(
                    RenderStatus.HIDDEN,
                    logics.getStatus(p.getX(), p.getY())
            );
        });
    }

    @Test
    void testCellCanBeRevealed() {
        int xToReveal = 0;
        int yToReveal = 0;
        logics.checkIfContainsBomb(xToReveal, yToReveal);
        assertNotEquals(RenderStatus.HIDDEN, logics.getStatus(xToReveal, yToReveal));
    }

    @Test
    void testAllBombsAreRevealedOnLost() {
        logics.revealAllBombs();
        var countOfBombsRevealed = getAllPositions().stream()
                .map(p -> logics.getStatus(p.getX(), p.getY()))
                .filter(RenderStatus.BOMB::equals)
                .count();
        assertEquals(BOMBS_COUNT, countOfBombsRevealed);
    }

    @Test
    void testOtherAreNotRevealedOnLost() {
        logics.revealAllBombs();
        var countOfHidden = getAllPositions().stream()
                .map(p -> logics.getStatus(p.getX(), p.getY()))
                .filter(RenderStatus.HIDDEN::equals)
                .count();
        var expected = BOARD_SIZE * BOARD_SIZE - BOMBS_COUNT;
        assertEquals(expected, countOfHidden);
    }

    @Test
    void testFlagCanBePutAndRemove() {
        var xToFlag = 0;
        var yToFlag = 0;
        logics.changeFlag(xToFlag, yToFlag);
        assertEquals(RenderStatus.FLAG, logics.getStatus(xToFlag, yToFlag));
        logics.changeFlag(xToFlag, yToFlag);
        assertEquals(RenderStatus.HIDDEN, logics.getStatus(xToFlag, yToFlag));
    }

    @Test
    void testCounterAdjacentGreaterThatZero() {
        logics.revealAll();
        var bombPosition = getAllPositions().stream()
                .filter(p -> logics.getStatus(p.getX(), p.getY()).equals(RenderStatus.BOMB))
                .findFirst().orElseThrow();
        var bombCell = new CellImpl(bombPosition.getX(), bombPosition.getY());
        var adjCellToBomb = getAllPositions().stream()
                .filter(p -> !logics.getStatus(p.getX(), p.getY()).equals(RenderStatus.BOMB))
                .map(p -> new CellImpl(p.getX(), p.getY()))
                .filter(bombCell::isAdjacentTo)
                .findFirst().orElseThrow();
        var zeroBombsAdj = 0;
        assertNotEquals(
                zeroBombsAdj,
                logics.getStatus(adjCellToBomb.getRow(), adjCellToBomb.getColumn()).getCounter()
        );
    }

    @Test
    void testAdjacentWithCountZeroAreRevealed() {
        var noBomb = 0;
        logics = new LogicsImpl(BOARD_SIZE, noBomb);
        var xToReveal = 0;
        var yToReveal = 0;
        logics.checkIfContainsBomb(xToReveal, yToReveal);
        var countOfRevealed = getAllPositions().stream()
                .map(p -> logics.getStatus(p.getX(), p.getY()))
                .filter(RenderStatus.COUNTER::equals)
                .count();
        var expected = BOARD_SIZE * BOARD_SIZE;
        assertEquals(expected, countOfRevealed);
    }

    @Test
    void testWin() {
        var noBomb = 0;
        logics = new LogicsImpl(BOARD_SIZE, noBomb);
        assertFalse(logics.won());
        var xToReveal = 0;
        var yToReveal = 0;
        logics.checkIfContainsBomb(xToReveal, yToReveal);
        assertTrue(logics.won());
    }

    private List<Pair<Integer, Integer>> getAllPositions() {
        var allPositions = new ArrayList<Pair<Integer, Integer>>();
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                allPositions.add(new Pair<>(i, j));
            }
        }
        return allPositions;
    }
}