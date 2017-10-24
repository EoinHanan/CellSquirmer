package Input;

/**
 * Created by EoinH on 27/09/2017.
 */
public class Investigate implements Command {
    private InputProxy commandProxy;

    public Investigate(InputProxy commandProxy) {
        this.commandProxy = commandProxy;
    }

    @Override
    public void execute(String secondWord) {
       commandProxy.executeInvestigate();
    }
}
