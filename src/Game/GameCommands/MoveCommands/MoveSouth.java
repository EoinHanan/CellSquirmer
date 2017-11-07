package Game.GameCommands.MoveCommands;

import Game.GameProxy;
import Game.Move;
import World.Map;
import Character.Position;

/**
 * Created by EoinH on 07/11/2017.
 */
public class MoveSouth implements MoveCommand {
    private String name;
    private GameProxy gameProxy;

    public MoveSouth(GameProxy gameProxy){
        this.gameProxy = gameProxy;
        name = "South";
    }

    @Override
    public void execute(Position position, Map map) {
        boolean valid;
        Move southMove = new Move(0, -1);
        valid = southMove.validateMove(0, -1, position, map);
        if (!valid){
            gameProxy.executeInValid("This is not a valid move. Choose another direction.");
        }
        else
            gameProxy.executeValid("You moved South.",southMove);
    }

    @Override
    public String getName() {
        return name;
    }
}
