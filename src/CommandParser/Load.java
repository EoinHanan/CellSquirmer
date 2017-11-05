package CommandParser;

/**
 * Created by EoinH on 05/11/2017.
 */
public class Load implements Command {
    private CommandParserProxy commandProxy;
    private String name;

    public Load(CommandParserProxy commandProxy){
        this.commandProxy = commandProxy;
        name = "Load";
    }

    @Override
    public void execute(String saveName) {
        commandProxy.executeLoad(saveName);
    }

    @Override
    public String getName() {
        return name;
    }
}
