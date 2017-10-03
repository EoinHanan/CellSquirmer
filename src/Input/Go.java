package Input;

import Character.Observer;
/**
 * Created by EoinH on 27/09/2017.
 */
public class Go implements Command, Subject {
    private String[] validDirections = {"north","south","east","west"};
    String validCommand;
    Observer observer;

    public Go(Observer o ){
        register(o);
    }

    @Override
    public void execute(String direction) {
        //To do check direction.
        boolean valid = false;
        for (int i =0; i < validDirections.length && !valid;i++)
            if (direction.equals(validDirections[i]))
                valid=true;
        if (valid){
            validCommand = direction;
        }
        else{

        }
    }
    private boolean checkValid(){
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
