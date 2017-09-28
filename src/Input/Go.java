package Input;

/**
 * Created by EoinH on 27/09/2017.
 */
public class Go implements Command {
    private String direction;

    public Go(String direction){
        this.direction=direction;
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
