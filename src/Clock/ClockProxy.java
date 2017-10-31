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
        setColleagueCode("Clock");
    }
    @Override
    public void receive(Message message) {
        if(message.getDestination().equals(this.getColleagueCode()) && message.getAction().equals("Time Request"))
            this.send(new Message("GUI", this.getColleagueCode(),clock.getTime().toString(),"Time Print"));
    }
}
