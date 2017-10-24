package Input;

/**
 * Created by EoinH on 27/09/2017.
 */
public class Go implements Command  {
    private InputProxy commandProxy;

    public Go(InputProxy commandProxy) {
        this.commandProxy = commandProxy;
    }

    @Override
    public void execute(String direction) {
       commandProxy.executeGo(direction);
    }
}
