package CommandParser;

/**
 * Created by EoinH on 07/11/2017.
 */
public class Print implements Command {
    private String name;
    CommandParserProxy commandProxy;
    public Print(CommandParserProxy commandProxy) {
        this.commandProxy = commandProxy;
        name = "take";
    }

    @Override
    public void execute(String secondWord) {
        commandProxy.executePrint();
    }

    @Override
    public String getName() {
        return name;
    }
}
