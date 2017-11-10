package Game.GameCommands.MoveCommands;

import Game.GameColleague;
import Game.Play;
import Character.Position;
import World.Map;

/**
 * Created by EoinH on 07/11/2017.
 */
public class MoveError implements MoveCommand {
    private String name;
    private GameColleague gameProxy;

    public MoveError (GameColleague gameProxy){
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
