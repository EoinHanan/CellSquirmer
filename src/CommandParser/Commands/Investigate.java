package CommandParser.Commands;

import CommandParser.CommandParserColleague;

public class Investigate implements Command {
    private CommandParserColleague commandProxy;
    private String name;

    public Investigate(CommandParserColleague commandProxy) {
        this.commandProxy = commandProxy;
        name = "investigate";
    }

    @Override
    public void execute(String secondWord) {
       commandProxy.executeInvestigate();
    }

    @Override
    public String getName() {
        return name;
    }
}
