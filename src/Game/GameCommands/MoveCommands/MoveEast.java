package Game.GameCommands.MoveCommands;

import Game.GameProxy;
import Game.Move;
import World.Map;
import Character.Position;

/**
 * Created by EoinH on 07/11/2017.
 */
public class MoveEast implements MoveCommand{
    private String name;
    private GameProxy gameProxy;

    public MoveEast(GameProxy gameProxy){
        name = "east";
        this.gameProxy = gameProxy;
    }

    @Override
    public void execute(Position position, Map map) {
        boolean valid;
        Move eastMove = new Move(1, 0);
        valid = eastMove.validateMove(1, 0, position, map);
        if (!valid){
            gameProxy.executeInValid("This is not a valid move. Choose another direction.");
        }
        else
            gameProxy.executeValid("You moved East.", eastMove);
    }

    @Override
    public String getName() {
        return name;
    }
}
