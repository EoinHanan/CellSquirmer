package Game.GameCommands.MoveCommands;

import Game.GameProxy;
import Game.Move;
import World.Map;

import Character.Position;

/**
 * Created by EoinH on 07/11/2017.
 */
public class MoveWest implements MoveCommand {
    private String name;
    private GameProxy gameProxy;

    public MoveWest(GameProxy gameProxy){
        this.gameProxy = gameProxy;
        name = "west";
    }

    @Override
    public void execute(Position position, Map map) {
        boolean valid;
        Move westMove = new Move(-1, 0);
        valid = westMove.validateMove(-1, 0, position, map);
        if (!valid){
            gameProxy.executeInValid("This is not a valid move. Choose another direction.");
        }
        else
            gameProxy.executeValid("You moved West.", westMove);

    }

    @Override
    public String getName() {
        return name;
    }
}
