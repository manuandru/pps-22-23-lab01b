package e2.logic.grid;

import e2.logic.grid.cell.Cell;
import e2.logic.grid.cell.CellImpl;
import e2.logic.grid.cell.CellState;

import java.util.*;

public class GridImpl implements Grid {

    private final Map<Cell, CellState> grid = new HashMap<>();
    private final int gridSize;
    public GridImpl(int size, int bombCount) {
        gridSize = size;
        Set<Integer> bombsPosition = getRandomBombsPosition(bombCount);
        int bombCounter = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (bombsPosition.contains(bombCounter)) {
                    grid.put(new CellImpl(i,j), CellState.BOMB);
                } else {
                    grid.put(new CellImpl(i,j), CellState.EMPTY);
                }
                bombCounter++;
            }
        }
    }

    private Set<Integer> getRandomBombsPosition(int bombCount) {
        var random = new Random();
        var returnSet = new HashSet<Integer>();
        while (returnSet.size() != bombCount) {
            returnSet.add(random.nextInt(gridSize*gridSize));
        }
        return returnSet;
    }

    @Override
    public CellState getCellContent(Cell cell) {
        return grid.get(cell);
    }

    @Override
    public Set<Cell> getAllCells() {
        return this.grid.keySet();
    }
}
