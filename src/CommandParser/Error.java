package CommandParser;

/**
 * Created by EoinH on 24/10/2017.
 */
public class Error implements Command {
    private CommandParserProxy commandParserProxy;
    private String name;

    public Error(CommandParserProxy commandProxy) {
        this.commandParserProxy = commandProxy;
        name = "Error";
    }

    @Override
    public void execute(String direction) {
        commandParserProxy.sendError();
    }

    @Override
    public String getName() {
        return name;
    }
}
