package CommandParser.Commands;

import CommandParser.CommandParserProxy;

public class Delete implements Command {
    private CommandParserProxy commandProxy;
    private String name;

    public Delete(CommandParserProxy commandProxy){
        this.commandProxy = commandProxy;
        name = "delete";
    }
    @Override
    public void execute(String messageText) {
        commandProxy.executeDelete(messageText);
    }

    @Override
    public String getName() {
        return name;
    }
}
