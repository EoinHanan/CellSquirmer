package CommandParser.Commands;

import CommandParser.CommandParserProxy;

public class Go implements Command {
    private CommandParserProxy commandProxy;
    private String name;

    public Go(CommandParserProxy commandProxy) {
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
