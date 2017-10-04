package Input;

import Communication.Observer;
import Communication.Colleague;

/**
 * Created by EoinH on 27/09/2017.
 */
public class Go extends Colleague implements Command  {
    private String[] validDirections = {"north","south","east","west"};
    String validCommand;
    Observer observer;

    public Go(Observer o ){
        register(o);
    }

    @Override
    public void execute(String direction) {
        //To do check direction.
        if(checkValid(direction))
                observer.update(direction);
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

    @Override
    public void register(Observer o) {
        observer = o;
    }

    @Override
    public void unregister(Observer o) {
        //To delete possibly?
    }

    @Override
    public void notifyObserver() {
        observer.update(validCommand);
    }
}
