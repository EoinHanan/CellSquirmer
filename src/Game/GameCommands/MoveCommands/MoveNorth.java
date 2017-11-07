package Game.GameCommands.MoveCommands;

import Game.GameProxy;
import Game.Move;
import Character.Position;
import World.Map;

/**
 * Created by EoinH on 07/11/2017.
 */
public class MoveNorth implements MoveCommand {
    private String name;
    private GameProxy gameProxy;

    public MoveNorth (GameProxy gameProxy){
        name = "north";
        this.gameProxy = gameProxy;
    }

    @Override
    public void execute(Position position, Map map) {
        boolean valid;
        Move northMove = new Move(0, 1);
        valid = northMove.validateMove(0, 1, position, map);
        if (!valid){
            gameProxy.executeInValid("This is not a valid move. Choose another direction.");
        }
        else{
            gameProxy.executeValid("You moved north.",northMove);
        }
    }

    @Override
    public String getName() {
        return name;
    }
}
