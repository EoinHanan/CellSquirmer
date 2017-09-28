package Input;

/**
 * Created by EoinH on 27/09/2017.
 */
public class Investigate implements Command {


    public Investigate(){

        if (checkValid())
            execute();
    }

    @Override
    public void execute() {



    }
    private boolean checkValid(){
        return true;
    }
}
