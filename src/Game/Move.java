/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import Character.CheckpointCaretaker;
import World.Cell;
import World.Map;
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

    public boolean validateMove(int vMoveX, int vMoveY, Play play, Map map){
            boolean valid = false;
            int cpX;
            int cpY;
            int cmX, cmY;
            cpX = play.getcX() + vMoveX;
            cpY = play.getcY() + vMoveY;

            /*for(int i = 0; i < map.getSize(); i++){
                cmX = currentMap[i].getPositionX();
                cmY = currentMap[i].getPositionY();
                if(cpX == cmX && cpY ==cmY)
                    valid = true;
                    play.setcX(cpX);
                    play.setcY(cpY);
            }*/

            if (cpY > 0 && cpY < map.getSize() && cpX > 0 && cpX < map.getSize()){
                play.setcX(cpX);
                play.setcY(cpY);
                valid = true;
            }

            return valid;
    }
}
