package Input;

/**
 * Created by EoinH on 24/10/2017.
 */
public class Error implements Command {
    private InputProxy inputProxy;

    public Error(InputProxy commandProxy) {
        this.inputProxy = commandProxy;
    }

    @Override
    public void execute(String direction) {
        inputProxy.sendError();
    }
}
