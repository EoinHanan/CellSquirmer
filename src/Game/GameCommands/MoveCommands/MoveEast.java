package Game.GameCommands.MoveCommands;

import Game.GameColleague;
import Game.Move;
import Game.Play;
import World.Map;
import Character.Position;
import Interceptor.*;
/**
 * Created by EoinH on 07/11/2017.
 */
public class MoveEast implements MoveCommand{
    private String name;
    private GameColleague gameProxy;

    Interceptor interceptor = new Interceptor() {
        MoveRequest request = new MoveRequest(getClass().getName());

        public void errorMessageReceiver(Context context) {
            request.printError(context.getFinalErrorMessage());

        }

        public void updateMomento(ConcreteMomentoInterceptor play){
            System.out.print("updateMomento");
        }
    };

    public MoveEast(GameColleague gameProxy){
        name = "east";
        this.gameProxy = gameProxy;
    }

    @Override
    public void execute(Position position, Map map, Play play) {
        Dispatcher.getInstance().registerInterceptor(interceptor);
        boolean valid;
        Move eastMove = new Move(1, 0);
        Position myPosition = play.getPosition();
        valid = eastMove.validateMove(1, 0, position, map);
        if (!valid){
            gameProxy.executeInValid("This is not a valid move. Choose another direction.");
            ConcreteInterceptor interceptorObject = new ConcreteInterceptor("Invalid direction Input, cannot move East");
            gameProxy.executeInValid("This is not a valid move. Choose another direction.");
        }
        else {
            ConcreteMomentoInterceptor ConcreteMomentoObject = new ConcreteMomentoInterceptor(play, myPosition);
            Dispatcher.getInstance().updateMomento(ConcreteMomentoObject);

            gameProxy.executeValid("You moved East.", eastMove);
        }
        Dispatcher.getInstance().unregisterInterceptor(interceptor);

    }

    @Override
    public String getName() {
        return name;
    }
}
