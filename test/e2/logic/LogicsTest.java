package e2.logic;

import e2.gui.Pair;
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
                    RenderState.HIDDEN,
                    logics.getStatus(p.getX(), p.getY())
            );
        });
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