package Input;

import Character.Observer;
/**
 * Created by EoinH on 27/09/2017.
 */
public class Investigate implements Command, Subject {
    Observer observer;
    String validCommand;

    public Investigate(Observer o){
        register(o);
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

    @Override
    public void register(Observer o) {
        observer = o;
    }

    @Override
    public void unregister(Observer o) {
        //To be deleted?
    }

    @Override
    public void notifyObserver() {

    }
}
