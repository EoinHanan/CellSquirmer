package CommandParser.Commands;

import CommandParser.CommandParserColleague;

public class Save implements Command {
    private CommandParserColleague commandProxy;
    private String name;

    public Save(CommandParserColleague commandProxy){
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
