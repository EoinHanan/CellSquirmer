/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import Character.CheckpointCaretaker;

/**
 *
 * @author Gerry
 */
public class Move {
    private int moveX;
    private int moveY;
     //check character to see if that is a valid move -> if so, update position in Character.
    public Move(int newMoveX, int newMoveY){
        this.moveX = newMoveX;
        this.moveY = newMoveY;
    }
    public int getMoveX(){
        return  this.moveX;
    }

    public int getMoveY() {
        return moveY;
    }

    public void setMoveX(int moveX) {
        this.moveX = moveX;
    }

    public void setMoveY(int moveY) {
        this.moveY = moveY;
    }

    public void validateMove(int vMoveX, int vMoveY){
            int cpX;
            int cpY;
            //cpX = c.getXValue();
    }
}
