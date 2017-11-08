package CommandParser.Commands;

import CommandParser.CommandParserProxy;

public class Save implements Command {
    private CommandParserProxy commandProxy;
    private String name;

    public Save(CommandParserProxy commandProxy){
        this.commandProxy = commandProxy;
        name = "save";
    }
    @Override
    public void execute(String messageText) {
        commandProxy.executeSave(messageText);
    }

    @Override
    public String getName() {
        return name;
    }
}
