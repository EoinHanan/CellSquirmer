/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import Multithreading.Autosaver;
import CommandParser.Combat.AttackColleague;
import Communication.ConcreteMediator;
import GUI.GUIColleague;
import CommandParser.CommandParserColleague;
import Multithreading.ClockColleague;
import World.Map;
import World.Cell;
import Character.*;

/**
 *
 * @author Gerry
 */
public class Play {
    private static ClockColleague clockProxy;
    private static GameColleague gameProxy;
    private static CommandParserColleague commandParserProxy;
    private static AttackColleague attackProxy;
    private static GUIColleague guiProxy;
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
        clockProxy = new ClockColleague(concreteMediator);
        gameProxy = new GameColleague(concreteMediator, map);
        guiProxy = new GUIColleague(concreteMediator);
        commandParserProxy = new CommandParserColleague(concreteMediator);
        attackProxy = new AttackColleague(concreteMediator);

        if (loaded){
            gameProxy.executeLoad(mapName);
        }

        else {
            gameProxy.executeSave(mapName);
        }
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
            //GUIColleague.inCombat();
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

    public void undo(){
        c.undoOperation();
    }
    protected void end(){
        autosaver.stopThread();
        clockProxy.stop();
        System.exit(0);
    }
}