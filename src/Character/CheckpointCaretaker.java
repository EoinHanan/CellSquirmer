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

    public CheckpointCaretaker(){
        mementoStack = new Stack();
        originatorStack = new Stack();
    }

    public void setWidget(Position p) {
        this.p = p;
    }

    public void undoOperation() {
        Originator o = (Originator)originatorStack.pop();
        o.restore((Memento)mementoStack.pop());
    }

    public void setXValue(int value) {
        // push the current state of the widget onto the stack
        mementoStack.push(p.createMemento());
        originatorStack.push(p);
        // do stuff
        p.setX(value);
    }

    public void setYValue(int value) {
        // push the current state of the widget onto the stack
        mementoStack.push(p.createMemento());
        originatorStack.push(p);
        // do stuff
        p.setY(value);
    }

    public int getXValue() {
        return p.getX();
    }

    public int getYValue() {
        return p.getY();
    }
}
