package Game.GameCommands.MoveCommands;

import Game.GameProxy;
import Game.Move;
import Game.Play;
import Character.Position;
import World.Map;

/**
 * Created by EoinH on 07/11/2017.
 */
public class MoveError implements MoveCommand {
    private String name;
    private GameProxy gameProxy;

    public MoveError (GameProxy gameProxy){
        name = "Error";
        this.gameProxy = gameProxy;
    }

    @Override
    public void execute(Position position, Map map, Play play) {
        gameProxy.executeInValid("You gave an incorrect input.");
    }

    @Override
    public String getName() {
        return name;
    }
}
