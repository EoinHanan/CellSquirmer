package CommandParser;

/**
 * Created by EoinH on 27/09/2017.
 */
public class Investigate implements Command {
    private CommandParserProxy commandProxy;

    public Investigate(CommandParserProxy commandProxy) {
        this.commandProxy = commandProxy;
    }

    @Override
    public void execute(String secondWord) {
       commandProxy.executeInvestigate();
    }
}
