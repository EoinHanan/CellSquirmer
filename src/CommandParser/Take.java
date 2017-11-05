package CommandParser;

/**
 * Created by EoinH on 27/09/2017.
 */
public class Take implements Command {
    private CommandParserProxy commandProxy;
    private String name;

    public Take(CommandParserProxy commandProxy) {
        this.commandProxy = commandProxy;
        name = "take";
    }

    @Override
    public void execute(String command) {
        commandProxy.executeTake();
    }

    @Override
    public String getName() {
        return name;
    }
}
