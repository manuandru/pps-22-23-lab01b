package e2.logic;

import e2.gui.RenderStatus;

public interface Logics {

    boolean checkIfContainsBomb(int x, int y);

    RenderStatus getStatus(int x, int y);

    void revealAllBombs();
}
