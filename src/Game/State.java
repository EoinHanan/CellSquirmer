/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import Character.Position;
import World.Cell;
import World.Map;


/**
 *
 * @author Gerry
 */
public class State {


    //get current position, check map for that position, retrieve state

    public State(){

    }

    public int checkState(Map map, Play play){
        int cpX;
        int cpY;
        cpX = play.getcX();
        cpY = play.getcY();

        return map.getCell(cpX,cpY).getState();
    }

}
