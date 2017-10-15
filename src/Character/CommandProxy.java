package Character;


import Communication.Colleague;
import Communication.Mediator;
import Communication.Message;

/**
 * Created by EoinH on 03/10/2017.
 */
public class CommandProxy extends Colleague {


    public CommandProxy(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void receive(Message message) {

    }
}
