package CommandParser.Commands;

import CommandParser.CommandParserColleague;

public class Load implements Command {
    private CommandParserColleague commandProxy;
    private String name;

    public Load(CommandParserColleague commandProxy){
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
