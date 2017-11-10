package CommandParser.Commands;

import CommandParser.CommandParserColleague;

public class Update implements Command {
    private CommandParserColleague commandProxy;
    private String name;

    public Update(CommandParserColleague commandProxy){
        this.commandProxy = commandProxy;
        name = "update";
    }
    @Override
    public void execute(String messageText) {
        commandProxy.executeUpdate(messageText);
    }

    @Override
    public String getName() {
        return name;
    }
}
