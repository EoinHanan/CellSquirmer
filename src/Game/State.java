/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import Character.Position;
import World.Cell;


/**
 *
 * @author Gerry
 */
public class State {


    //get current position, check map for that position, retrieve state

    public State(){

    }

    public int checkState(Play play){
        int cpX;
        int cpY;
        int state = 0;
        cpX = play.getcX();
        cpY = play.getcY();
        Cell[] currentMap = play.getMap();
        for(int i = 0; i < play.getMap().length; i++) {

            if(cpX == currentMap[i].getPositionX() && cpY == currentMap[i].getPositionY())
                state = currentMap[i].getState();

        }
        return state;
    }

}
