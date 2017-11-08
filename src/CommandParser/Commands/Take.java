package CommandParser.Commands;

import CommandParser.CommandParserProxy;

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
