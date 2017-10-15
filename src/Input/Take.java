package Input;

import Communication.*;

/**
 * Created by EoinH on 27/09/2017.
 */
public class Take extends Colleague implements Command {
    Observer observer;
    String validCommand;

    public Take(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void receive(Message message) {

    }


    public boolean checkValid(){
        return true;
    }

    @Override
    public void execute(String command) {
        if (checkValid())
            observer.update(command);
        else
            System.out.print("Validity test failed");

    }
}
