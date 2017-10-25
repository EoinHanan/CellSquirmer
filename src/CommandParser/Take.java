package CommandParser;

/**
 * Created by EoinH on 27/09/2017.
 */
public class Take implements Command {
    CommandParserProxy commandProxy;

    public Take(CommandParserProxy commandProxy) {
        this.commandProxy = commandProxy;
    }

    @Override
    public void execute(String command) {
        commandProxy.executeTake();
    }
}
