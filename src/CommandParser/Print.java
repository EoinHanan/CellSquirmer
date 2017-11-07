package CommandParser;

/**
 * Created by EoinH on 07/11/2017.
 */
public class Print implements Command {
    private String name;
    private CommandParserProxy commandProxy;
    public Print(CommandParserProxy commandProxy) {
        this.commandProxy = commandProxy;
        name = "print";
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
