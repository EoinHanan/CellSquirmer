/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import Clock.Clock;
import Communication.ConcreteMediator;
import Communication.Mediator;
import Input.InputProxy;
import Output.OutputProxy;
import Clock.ClockProxy;
import Communication.ConcreteMediator;
import Input.InputProxy;
import Output.OutputProxy;
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
    private static InputProxy inputProxy;
    private static OutputProxy outputProxy;
    private static ConcreteMediator concreteMediator;


    private int sizeOfMap;
    private int cX;
    private int cY;

    public Play(int sizeOfMap, int x, int y) {
        this.cX = x;
        this.cY = y;
        this.sizeOfMap = sizeOfMap;

        concreteMediator = new ConcreteMediator();
        clockProxy = new ClockProxy(concreteMediator);
        gameProxy = new GameProxy(concreteMediator, this);
        inputProxy = new InputProxy(concreteMediator);
        outputProxy = new OutputProxy(concreteMediator);

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

    public void start() {
        Cell currentmap[];
        Map map = new Map();
        currentmap  = map.CreateMap(sizeOfMap);
        int i = 0;
        int state = 0;
        Position myPosition = new Position(cX, cY);
        CheckpointCaretaker c = new CheckpointCaretaker(myPosition);
        while (state != -1 || state != 1) {
            gameProxy.updatePlay(this);
            cX = c.getXValue();
            cY = c.getYValue();
            outputProxy.lookForInput();

            //if recieved message is go, work through Move Class

            //else if recieved message is investigate, work through State Class

        }

    }

    
}
