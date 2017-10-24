package Input;

import Communication.*;

/**
 * Created by EoinH on 27/09/2017.
 */
public class Take implements Command {
    CommandProxy commandProxy;

    public Take(CommandProxy commandProxy) {
        this.commandProxy = commandProxy;
    }

    @Override
    public void execute(String command) {
        commandProxy.executeTake();
    }
}
