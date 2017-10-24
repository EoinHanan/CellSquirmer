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
import World.Map;
import World.Cell;
import Clock.ClockProxy;
import Character.Position;
import Character.CheckpointCaretaker;

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


    private int sizeofmap;

    public Play(int sizeofmap){
        concreteMediator = new ConcreteMediator();
        clockProxy = new ClockProxy(concreteMediator);
        gameProxy = new GameProxy(concreteMediator);
        inputProxy = new InputProxy(concreteMediator);
        outputProxy = new OutputProxy(concreteMediator);


        Cell currentmap [];
        Map map = new Map();
        currentmap = map.CreateMap(sizeofmap);

        int i = 0;
        int state = 0;
        Position myPosition = new Position(0,0);
        CheckpointCaretaker c = new CheckpointCaretaker();

        while(state != -1 || state != 1){
            //if received message is go, work through Move Class
            outputProxy.lookForInput();
            //else if received message is investigate, work through State Class

        }
    }
}
