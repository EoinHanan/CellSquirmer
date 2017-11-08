package CommandParser.Commands;

import CommandParser.CommandParserProxy;

public class Load implements Command {
    private CommandParserProxy commandProxy;
    private String name;

    public Load(CommandParserProxy commandProxy){
        this.commandProxy = commandProxy;
        name = "load";
    }

    @Override
    public void execute(String messageText) {
        commandProxy.executeLoad(messageText);
    }

    @Override
    public String getName() {
        return name;
    }
}
