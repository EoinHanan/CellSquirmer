/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import Character.CheckpointCaretaker;
import World.Cell;
import com.sun.org.apache.xpath.internal.operations.Bool;

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

    public boolean validateMove(int vMoveX, int vMoveY, Play play){
            Boolean valid = false;
            int cpX;
            int cpY;
            int cmX, cmY;
            cpX = play.getcX() + vMoveX;
            cpY = play.getcY() + vMoveY;
            Cell [] currentMap = play.getMap();
            for(int i = 0; i < play.getMap().length; i++){
                cmX = currentMap[i].getPositionX();
                cmY = currentMap[i].getPositionY();
                if(cpX == cmX && cpY ==cmY)
                    valid = true;
                    play.setcX(cpX);
                    play.setcY(cpY);
            }
            return valid;
    }
}
