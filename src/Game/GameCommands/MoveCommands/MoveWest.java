package Game.GameCommands.MoveCommands;

import Game.GameProxy;
import Game.Move;
import Game.Play;
import World.Map;
import Character.Position;
import Character.CheckpointCaretaker;
import Interceptor.*;

import Character.Position;

/**
 * Created by EoinH on 07/11/2017.
 */
public class MoveWest implements MoveCommand {
    private String name;
    private GameProxy gameProxy;

    Interceptor interceptor = new Interceptor() {
        MoveRequest request = new MoveRequest(getClass().getName());

        public void errorMessageReceiver(Context context) {
            request.printError(context.getFinalErrorMessage());

        }

        public void updateMomento(ConcreteMomentoInterceptor play){
            System.out.print("in top of game proxy");
        }
    };

    public MoveWest(GameProxy gameProxy){
        this.gameProxy = gameProxy;
        name = "west";
    }

    @Override
    public void execute(Position position, Map map, Play play) {
        boolean valid;
        Move westMove = new Move(-1, 0);
        Position myPosition = play.getPosition();
        valid = westMove.validateMove(-1, 0, position, map);
        if (!valid){
            gameProxy.executeInValid("This is not a valid move. Choose another direction.");
            ConcreteInterceptor testint = new ConcreteInterceptor("Invalid direction Input, cannot move West");
            Dispatcher.getInstance().errorMessageReceiver(testint);
        }
        else {
            gameProxy.executeValid("You moved West.", westMove);
            ConcreteMomentoInterceptor testcare = new ConcreteMomentoInterceptor(play, myPosition);
            Dispatcher.getInstance().updateMomento(testcare);
        }

    }

    @Override
    public String getName() {
        return name;
    }
}
