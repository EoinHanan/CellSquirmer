package Input;

import Character.Observer;
/**
 * Created by EoinH on 27/09/2017.
 */
public class Take implements Command, Subject {
    Observer observer;
    String validCommand;

    public Take(Observer o){
        register(o);
    }

    public boolean checkValid(){
        return false;
    }

    @Override
    public void execute(String command) {
        if (checkValid())
            observer.update(command);


    }

    @Override
    public void register(Observer o) {
        observer = o;
    }

    @Override
    public void unregister(Observer o) {

    }

    @Override
    public void notifyObserver() {

    }
}
