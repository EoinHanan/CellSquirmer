package CommandParser;

/**
 * Created by EoinH on 05/11/2017.
 */
public class Save implements Command {
    private CommandParserProxy commandProxy;
    private String name;

    public Save(CommandParserProxy commandProxy){
        this.commandProxy = commandProxy;
        name = "Save";
    }
    @Override
    public void execute(String saveName) {
        commandProxy.executeSave(saveName);
    }

    @Override
    public String getName() {
        return name;
    }
}
