package CommandParser.Commands;

import CommandParser.CommandParserColleague;

public class Take implements Command {
    private CommandParserColleague commandProxy;
    private String name;

    public Take(CommandParserColleague commandProxy) {
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
