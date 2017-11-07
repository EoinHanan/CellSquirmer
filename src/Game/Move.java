/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import Character.CheckpointCaretaker;
import World.Cell;
import World.Map;
import Character.Position;

/**
 *
 * @author Gerry
 */
public class Move {
    private int moveX;
    private int moveY;
    private Position position;
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

    public boolean validateMove(int vMoveX, int vMoveY, Position position, Map map){
            boolean valid = false;
            int cpX;
            int cpY;
            int cmX, cmY;
            cpX = position.getX() + vMoveX;
            cpY = position.getY() + vMoveY;

            /*for(int i = 0; i < map.getSize(); i++){
                cmX = currentMap[i].getPositionX();
                cmY = currentMap[i].getPositionY();
                if(cpX == cmX && cpY ==cmY)
                    valid = true;
                    play.setcX(cpX);
                    play.setcY(cpY);
            }*/

            if (cpY > 0 && cpY < map.getSize() && cpX > 0 && cpX < map.getSize()){
                position.setX(cpX);
                position.setY(cpY);
                valid = true;
            }

            return valid;
    }

    public Position getPostition(){
        return position;
    }
}
