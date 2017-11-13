package World;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by EoinH on 13/11/2017.
 */
class CellFactoryTest {
    CellFactory mapLayout = new CellFactory();
    Cell[][] cells = new Cell[2][2];
    @Test
    void makeCell() {
        cells[0][0] = mapLayout.makeCell(1, 0, 0, false, 0);
        cells[0][1] = mapLayout.makeCell(2, 0, 1, false, 0);
        cells[1][1] = mapLayout.makeCell(3, 1, 1, true, 1);
        cells[1][0] = mapLayout.makeCell(4, 1, 2, false, 0);
        assertEquals(1, cells[0][0].getType());
        assertEquals(2, cells[0][1].getType());
        assertEquals(3, cells[1][1].getType());
        assertEquals(1, cells[1][1].getEnemyCount());
        assertEquals(4, cells[1][0].getType());

    }

}