package Clock;

import Communication.Colleague;
import Communication.Mediator;
import Communication.Message;

/**
 * Created by EoinH on 24/10/2017.
 */
public class ClockProxy extends Colleague {
    Clock clock;

    public ClockProxy (Mediator mediator){
        super(mediator);
        clock = new Clock();
    }
    @Override
    public void receive(Message message) {

        //To do Eoin code for Mediator interaction here.

    }
}
