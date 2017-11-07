package Game;

import Game.GameCommands.MoveCommands.*;
import World.Map;
import Character.Position;

/**
 * Created by EoinH on 07/11/2017.
 */
public class MoveRequestHandler {
    private MoveCommand commands[];

    public MoveRequestHandler(GameProxy gameProxy){
        commands = new MoveCommand[4];
        commands[0]= new MoveNorth(gameProxy);
        commands[1]= new MoveEast(gameProxy);
        commands[2]= new MoveSouth(gameProxy);
        commands[3]= new MoveWest(gameProxy);
    }

    public void handle(String direction, Map map, Position position){
        boolean found = false;
        int i = 0;
        while(i < commands.length && !found){
            if (commands[i].getName().equals(direction))
                found = true;
            else
                i++;
        }

        commands[i].execute(position,map);
    }
}
