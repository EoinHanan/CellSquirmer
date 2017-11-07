package Character;

class CheckpointCaretakerTest {

    public static void main (String[] args){
        Position myPosition = new Position(2, 2);
        CheckpointCaretaker c = new CheckpointCaretaker(myPosition);

        c.setPosition(myPosition);
        c.setXValue(myPosition.getX());
        c.setYValue(myPosition.getY());
        System.out.println(c.getXValue());
        System.out.println(c.getYValue());
        c.setXValue(3);
        c.setYValue(3);
        System.out.println(c.getXValue());
        System.out.println(c.getYValue());
        c.undoOperation();
        System.out.println(c.getXValue());
        System.out.println(c.getYValue());
    }
}