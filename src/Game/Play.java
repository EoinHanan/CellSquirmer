/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import Clock.Clock;
import Communication.ConcreteMediator;
import Communication.Mediator;
import GUI.GUIProxy;
import CommandParser.CommandParserProxy;
import Clock.ClockProxy;
import Communication.ConcreteMediator;
import World.Map;
import World.Cell;
import Character.*;

/**
 *
 * @author Gerry
 */
public class Play {
    private static ClockProxy clockProxy;
    private static GameProxy gameProxy;
    private static CommandParserProxy commandParserProxy;
    private static GUIProxy guiProxy;
    private static ConcreteMediator concreteMediator;


    private int sizeOfMap;
    private int cX;
    private int cY;
    private Cell map [];

    public Play(int sizeOfMap, int x, int y, Cell [] currentMap) {
        this.cX = x;
        this.cY = y;
        this.sizeOfMap = sizeOfMap;
        this.map = currentMap;


        //Map map = new Map();
        concreteMediator = new ConcreteMediator();
        clockProxy = new ClockProxy(concreteMediator);
        gameProxy = new GameProxy(concreteMediator, this);
        guiProxy = new GUIProxy(concreteMediator);
        commandParserProxy = new CommandParserProxy(concreteMediator);

    }

    public void setSizeOfMap(int sizeOfMap) {
        this.sizeOfMap = sizeOfMap;
    }

    public void setcX(int cX) {
        this.cX = cX;
    }

    public void setcY(int cY) {
        this.cY = cY;
    }

    public int getSizeOfMap(){
        return this.sizeOfMap;
    }

    public int getcX(){
        return this.cX;
    }

    public int getcY() {
        return cY;
    }

    public Cell[] getMap(){
        return this.map;
    }

    public void setMap(Cell currentMap[]){
        this.map = currentMap;
    }

    public void start() {
        int i = 0;
        int state = 0;
        Position myPosition = new Position(cX, cY);
        CheckpointCaretaker c = new CheckpointCaretaker(myPosition);
        while (state != -1 || state != 1) {
            gameProxy.updatePlay(this);
            cX = c.getXValue();
            cY = c.getYValue();
            guiProxy.lookForInput();
            c.setXValue(cX);
            c.setYValue(cY);

            //if recieved message is go, work through Move Class

            //else if recieved message is investigate, work through State Class

        }

    }




    
}
