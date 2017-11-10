package CommandParser.Commands;

import CommandParser.CommandParserColleague;

public class Go implements Command {
    private CommandParserColleague commandProxy;
    private String name;

    public Go(CommandParserColleague commandProxy) {
        this.commandProxy = commandProxy;
        name = "go";
    }

    @Override
    public void execute(String direction) {
       commandProxy.executeGo(direction);
    }

    @Override
    public String getName() {
        return name;
    }
}
