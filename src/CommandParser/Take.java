package CommandParser;

/**
 * Created by EoinH on 27/09/2017.
 */
public class Take implements Command {
    InputProxy commandProxy;

    public Take(InputProxy commandProxy) {
        this.commandProxy = commandProxy;
    }

    @Override
    public void execute(String command) {
        commandProxy.executeTake();
    }
}
