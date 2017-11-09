/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import Autosaver.Autosaver;
import Clock.Clock;
import Combat.Attack;
import Combat.AttackProxy;
import Communication.ConcreteMediator;
import Communication.Message;
import Communication.Colleague;
import Communication.Mediator;
import GUI.GUIProxy;
import CommandParser.CommandParserProxy;
import Clock.ClockProxy;
import Communication.ConcreteMediator;
import World.Map;
import World.Cell;
import Character.*;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author Gerry
 */
public class Play {
    private static ClockProxy clockProxy;
    private static GameProxy gameProxy;
    private static CommandParserProxy commandParserProxy;
    private static AttackProxy attackProxy;
    private static GUIProxy guiProxy;
    private static ConcreteMediator concreteMediator;
    private static Autosaver autosaver;

    private int cX;
    private int cY;
    private Position myPosition;
    private CheckpointCaretaker c;
    private static Map map;
    private boolean inCombat;

    public Play(int sizeOfMap, int x, int y, String mapName, boolean loaded) {
        this.cX = x;
        this.cY = y;
        map = new Map(sizeOfMap);

        myPosition = new Position(cX, cY);
        c = new CheckpointCaretaker(myPosition);
        autosaver = new Autosaver(mapName);

        concreteMediator = new ConcreteMediator();
        clockProxy = new ClockProxy(concreteMediator);
        gameProxy = new GameProxy(concreteMediator, map);
        guiProxy = new GUIProxy(concreteMediator);
        commandParserProxy = new CommandParserProxy(concreteMediator);
        attackProxy = new AttackProxy(concreteMediator);

        if (loaded)
            gameProxy.executeLoad(mapName);
        else
            gameProxy.executeSave(mapName);
    }

    public int getcX(){
        return this.cX;
    }

    public int getcY() {
        return this.cY;
    }

    public CheckpointCaretaker getCaretaker(){
        return c;
    }


    public void start() {
        int i = 0;
        int state = 0;
//        Position myPosition = new Position(cX, cY);
//        CheckpointCaretaker c = new CheckpointCaretaker(myPosition);
        while (state != -1 && state != 1) {
            if (!inCombat) {
                movementLoop(c);
            }
            else{
                guiProxy.lookForInput(inCombat);
            }
            state = gameProxy.getCheck();
            inCombat = attackProxy.checkCombat();
        }
        end();

    }

    public void movementLoop( CheckpointCaretaker c){

        gameProxy.updatePlay(this);

        cX = c.getXValue();
        cY = c.getYValue();
        Cell myCell = map.getCell(cX, cY);
        //System.out.println("Checking the cell" + map.getCell(cX, cY).getEnemy().getHealth());

        //System.out.println(myCell.getEnemyCount());
        if(myCell.getEnemyCount() > 0){
            //GUIProxy.inCombat();
            //Call gameProxy method here
            gameProxy.sendCombatMessage();
            inCombat = true;
            attackProxy.setCurrentEnemy(myCell.getEnemy());
            myCell.setEnemyCount(myCell.getEnemyCount() - 1);
        }
        guiProxy.lookForInput(inCombat);
        autosaver.updateMap(map);
        autosaver.updateMapName(gameProxy.getMapName());
//        c.setPosition(myPosition);
//        c.setXValue(myPosition.getX());
//        c.setYValue(myPosition.getY());
    }

    public void setPosition(Position position){
        c.setPosition(position);
    }

    public Position getPosition(){
        return c.getPosition();
    }
    protected void end(){
        autosaver.stopThread();
        clockProxy.stop();
        System.exit(0);
    }
}