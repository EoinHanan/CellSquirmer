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



    private static Map map;
    private PlayerCharacter character;

    public Play(int sizeOfMap, int x, int y) {
        character = new PlayerCharacter(new Position(x,y));

        map = new Map(sizeOfMap);
        concreteMediator = new ConcreteMediator();
        clockProxy = new ClockProxy(concreteMediator);
        gameProxy = new GameProxy(concreteMediator, map);
        guiProxy = new GUIProxy(concreteMediator);
        commandParserProxy = new CommandParserProxy(concreteMediator);

    }

    public void start() {
        int i = 0;
        int state = 0;
        Position myPosition = character.getPosition();
        CheckpointCaretaker c = new CheckpointCaretaker(myPosition);
        while (state != -1 && state != 1) {
            gameProxy.updatePlay(this);
            myPosition.setX(c.getXValue());
            myPosition.setY(c.getYValue());
            guiProxy.lookForInput();
            c.setPosition(myPosition);
            state = gameProxy.getCheck();
            //if recieved message is go, work through Move Class

            //else if recieved message is investigate, work through State Class

        }

    }




    
}
