package Input;

import Character.Observer;
/**
 * Created by EoinH on 27/09/2017.
 */
public class Take implements Command {
    Observer observer;
    public Take(Observer o){
        observer = o;
    }

    public boolean checkValid(){
        return false;
    }

    @Override
    public void execute() {

    }
    public void execute(String command) {
        if (checkValid())
            observer.update(command);


    }

}
