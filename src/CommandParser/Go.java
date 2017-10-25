package CommandParser;

/**
 * Created by EoinH on 27/09/2017.
 */
public class Go implements Command  {
    private CommandParserProxy commandProxy;

    public Go(CommandParserProxy commandProxy) {
        this.commandProxy = commandProxy;
    }

    @Override
    public void execute(String direction) {
       commandProxy.executeGo(direction);
    }
}
