package Input;

import Communication.Mediator;
import Communication.Message;
import Communication.Observer;
import Communication.Colleague;

/**
 * Created by EoinH on 27/09/2017.
 */
public class Go extends Colleague implements Command  {
    private String[] validDirections = {"north","south","east","west"};
    private String validCommand;
    private String destination= "[Char]";
    private String source = "[go]";


    public Go(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void receive(Message message) {

    }


    @Override
    public void execute(String direction) {
        Message message = new Message("To do replace", "Replace this", "Needs to be replaced");
        //To do check direction.
        if(checkValid(direction))
                this.send(message);
        else
            System.out.println("Invalid direction");
    }
    private boolean checkValid(String direction){
        boolean valid = false;
        for (int i =0; i < validDirections.length && !valid;i++)
            if (direction.equals(validDirections[i]))
                valid=true;
        if (valid){
            validCommand = direction;
        }
        else{

        }
        return true;
    }

}
