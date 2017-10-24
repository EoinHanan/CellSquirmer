package Input;

import Communication.Mediator;
import Communication.Message;
import Communication.Observer;
import Communication.Colleague;

/**
 * Created by EoinH on 27/09/2017.
 */
public class Go implements Command  {
    private CommandProxy commandProxy;

    public Go(CommandProxy commandProxy) {
        this.commandProxy = commandProxy;
    }

    @Override
    public void execute(String direction) {
       commandProxy.executeGo();
    }
}
