package Character;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckpointCaretakerJUnitTest {
    Position myPosition = new Position(2, 2);
    CheckpointCaretaker c = new CheckpointCaretaker(myPosition);


    @Test
    void undoOperation() {
        c.setXValue(myPosition.getX());
        c.setYValue(myPosition.getY());
        assertEquals(2, c.getXValue());
        assertEquals(2, c.getYValue());
        c.setXValue(3);
        c.setYValue(3);
        assertEquals(3, c.getXValue());
        assertEquals(3, c.getYValue());
        c.undoOperation();
        assertEquals(2, c.getXValue());
        assertEquals(2, c.getYValue());
    }

    @Test
    void setXValue() {
        c.setXValue(4);
        assertEquals(4, c.getXValue());
    }

    @Test
    void setYValue() {
        c.setYValue(18);
        assertEquals(18, c.getYValue());
    }

}