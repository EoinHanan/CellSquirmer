package Input;

import Communication.*;

/**
 * Created by EoinH on 27/09/2017.
 */
public class Investigate extends Colleague implements Command {
    Observer observer;
    String validCommand;

    public Investigate(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void receive(Message message) {

    }


    @Override
    public void execute(String secondWord) {
        if (checkValid())
            observer.update(validCommand);


    }
    private boolean checkValid(){
        //To do, check validity of world.

        return true;
    }

}
