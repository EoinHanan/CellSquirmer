package Character;
import java.util.ArrayList;
import java.util.Stack;
/*
Created on 02/10/17 by KieranF
Completely refactored on 24/10/17 by KieranF
 */

public class CheckpointCaretaker {

    private Stack mementoStack;
    private Stack originatorStack;
    private Position p;

    public CheckpointCaretaker(Position p){
        mementoStack = new Stack();
        originatorStack = new Stack();
        this.p= p;
    }

    public void setPosition(Position p) {
        if(p != null)
            this.p = p;

    }

    public Position getPosition() {
        return this.p;
    }

    public void undoOperation() {
        Originator o = (Originator)originatorStack.pop();
        o = (Originator)originatorStack.pop();
        mementoStack.pop();
        o.restore((Memento)mementoStack.pop());
    }

    public void setXValue(int value) {
        // push the current state of the widget onto the stack
        mementoStack.push(p.createMemento());
        originatorStack.push(p);
        p.setX(value);
    }

    public void setYValue(int value) {
        // push the current state of the widget onto the stack
        mementoStack.push(p.createMemento());
        originatorStack.push(p);
        p.setY(value);
        //System.out.println("Memento: " + p.getX() + ", " + p.getY());
    }

    public int getXValue() {
        return p.getX();
    }

    public int getYValue() {
        return p.getY();
    }
}
