package e2.logic;

import e2.gui.Pair;
import e2.gui.RenderStatus;
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