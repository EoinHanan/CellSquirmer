package Game;

import Communication.Colleague;
import Communication.Mediator;
import Communication.Message;

public class GameProxy extends Colleague {
    private Message message;

    public GameProxy(Mediator mediator) {
        super(mediator);
        setColleagueCode("Game");
    }

    @Override
    public void receive(Message message) {

    }

    public void sendError(){
        message = new Message("Output","From", "Content","Action");
        this.send(message);
    }
}
