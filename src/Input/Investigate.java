package Input;

import Communication.*;

/**
 * Created by EoinH on 27/09/2017.
 */
public class Investigate implements Command {
    private CommandProxy commandProxy;

    public Investigate(CommandProxy commandProxy) {
        this.commandProxy = commandProxy;
    }

    @Override
    public void execute(String secondWord) {
       commandProxy.executeInvestigate();
    }
}
