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
        commands = new MoveCommand[5];
        commands[0]= new MoveNorth(gameProxy);
        commands[1]= new MoveEast(gameProxy);
        commands[2]= new MoveSouth(gameProxy);
        commands[3]= new MoveWest(gameProxy);
        commands[4]= new MoveError(gameProxy);

    }

    public void handle(String direction, Map map, Play play){
        boolean found = false;
        int i = 0;
        while(i < commands.length - 1 && !found){
            if (commands[i].getName().equals(direction))
                found = true;
            else
                i++;
        }

        commands[i].execute(play.getPosition(),map,play);
    }
}
