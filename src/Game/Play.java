/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import Clock.Clock;
import Combat.Attack;
import Combat.AttackProxy;
import Communication.ConcreteMediator;
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



    private int cX;
    private int cY;
    private static Map map;
    private boolean inCombat;

    public Play(int sizeOfMap, int x, int y) {
        this.cX = x;
        this.cY = y;
        map = new Map(sizeOfMap);



        //Map map = new Map();
        concreteMediator = new ConcreteMediator();
        clockProxy = new ClockProxy(concreteMediator);
        gameProxy = new GameProxy(concreteMediator, map);
        guiProxy = new GUIProxy(concreteMediator);
        commandParserProxy = new CommandParserProxy(concreteMediator);
        attackProxy = new AttackProxy(concreteMediator);
    }


    public void setcX(int cX) {
        this.cX = cX;
    }

    public void setcY(int cY) {
        this.cY = cY;
    }

    public int getcX(){
        return this.cX;
    }

    public int getcY() {
        return cY;
    }


    public void start() {
        int i = 0;
        int state = 0;
        Position myPosition = new Position(cX, cY);
        CheckpointCaretaker c = new CheckpointCaretaker(myPosition);
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

    }

    public void movementLoop( CheckpointCaretaker c){

        gameProxy.updatePlay(this);
        cX = c.getXValue();
        cY = c.getYValue();
        Cell myCell = map.getCell(cX, cY);
        //System.out.println("Checking the cell" + map.getCell(cX, cY).getEnemy().getHealth());

        //System.out.println(myCell.getEnemyCount());
        if(myCell.getEnemyCount() > 0){
            GUIProxy.inCombat();
            inCombat = true;
            attackProxy.setCurrentEnemy(myCell.getEnemy());
            myCell.setEnemyCount(myCell.getEnemyCount() - 1);
        }
        guiProxy.lookForInput(inCombat);
        c.setXValue(cX);
        c.setYValue(cY);
    }
}
