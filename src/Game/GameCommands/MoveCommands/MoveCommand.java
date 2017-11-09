package Game.GameCommands.MoveCommands;

import World.Map;
import Character.Position;
import Game.Play;

/**
 * Created by EoinH on 07/11/2017.
 */
public interface MoveCommand {
    public void execute(Position position, Map map, Play play);
    public String getName();
}
