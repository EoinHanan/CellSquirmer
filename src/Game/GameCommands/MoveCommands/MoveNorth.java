package Game.GameCommands.MoveCommands;

import Game.GameProxy;
import Game.Move;
import Game.Play;
import World.Map;
import Character.Position;
import Interceptor.*;

/**
 * Created by EoinH on 07/11/2017.
 */
public class MoveNorth implements MoveCommand {
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


    public MoveNorth (GameProxy gameProxy){
        name = "north";
        this.gameProxy = gameProxy;
    }

    @Override
    public void execute(Position position, Map map, Play play) {
        Dispatcher.getInstance().registerInterceptor(interceptor);
        boolean valid;
        Move northMove = new Move(0, 1);
        Position myPosition = play.getPosition();
        valid = northMove.validateMove(0, 1, position, map);
        if (!valid){
            gameProxy.executeInValid("This is not a valid move. Choose another direction.");
            ConcreteInterceptor testint = new ConcreteInterceptor("Invalid direction Input, cannot move North");
            Dispatcher.getInstance().errorMessageReceiver(testint);
        }
        else{
            ConcreteMomentoInterceptor testcare = new ConcreteMomentoInterceptor(play,myPosition);
            Dispatcher.getInstance().updateMomento(testcare);
            gameProxy.executeValid("You moved north.",northMove);
        }
        Dispatcher.getInstance().unregisterInterceptor(interceptor);

    }

    @Override
    public String getName() {
        return name;
    }
}
