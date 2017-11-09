package CommandParser.Commands;

import CommandParser.CommandParserProxy;

public class Investigate implements Command {
    private CommandParserProxy commandProxy;
    private String name;

    public Investigate(CommandParserProxy commandProxy) {
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
