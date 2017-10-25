package CommandParser;

/**
 * Created by EoinH on 24/10/2017.
 */
public class Error implements Command {
    private CommandParserProxy commandParserProxy;

    public Error(CommandParserProxy commandProxy) {
        this.commandParserProxy = commandProxy;
    }

    @Override
    public void execute(String direction) {
        commandParserProxy.sendError();
    }
}
