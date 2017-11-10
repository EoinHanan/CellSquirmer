package CommandParser.Commands;

import CommandParser.CommandParserColleague;

public class Delete implements Command {
    private CommandParserColleague commandProxy;
    private String name;

    public Delete(CommandParserColleague commandProxy){
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
