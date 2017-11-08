package Game.GameCommands.MoveCommands;

import Game.GameProxy;
import Game.Move;
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
    public void execute(Position position, Map map) {
        gameProxy.executeInValid("You gave an incorrect input.");
    }

    @Override
    public String getName() {
        return name;
    }
}
