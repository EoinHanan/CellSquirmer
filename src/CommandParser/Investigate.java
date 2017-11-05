package CommandParser;

/**
 * Created by EoinH on 27/09/2017.
 */
public class Investigate implements Command {
    private CommandParserProxy commandProxy;
    private String name;

    public Investigate(CommandParserProxy commandProxy) {
        this.commandProxy = commandProxy;
        name = "investigate";
    }

    @Override
    public void execute(String secondWord) {
       commandProxy.executeInvestigate();
       name="Investigate";
    }

    @Override
    public String getName() {
        return name;
    }
}
