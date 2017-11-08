package Character;

/**
 * Created by KieranF on 04/10/2017.
 */

public class Position implements Originator{
    private int x = 0;
    private int y = 0;

    public Position(int x, int y){
        this.x = x; this.y = y;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) { this.y = y; }
    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Memento createMemento() {
        PositionMemento m = new PositionMemento();
        m.setX(new Integer(x));
        m.setY(new Integer(y));
        return m;
    }

    public void restore(Memento m) {
        PositionMemento pm = (PositionMemento)m;
        this.x = ((Integer)pm.getX()).intValue();
        this.y = ((Integer)pm.getY()).intValue();
    }


    class PositionMemento implements Memento{
        Integer xState;
        Integer yState;

        public Object getX() { return xState; }

        public Object getY() { return yState; }

        public void setX(Object x) { this.xState = (Integer)x; }

        public void setY(Object y){ this.yState = (Integer)y; }

    }

}
