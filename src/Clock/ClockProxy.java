package Clock;

import Communication.Colleague;
import Communication.Mediator;
import Communication.Message;

/**
 * Created by EoinH on 24/10/2017.
 */
public class ClockProxy extends Colleague {

    public ClockProxy (Mediator mediator){
        super(mediator);
    }
    @Override
    public void receive(Message message) {

    }
}
