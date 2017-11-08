package CommandParser.Commands;

import CommandParser.CommandParserProxy;

public class Error implements Command {
    private CommandParserProxy commandParserProxy;
    private String name;

    public Error(CommandParserProxy commandProxy) {
        this.commandParserProxy = commandProxy;
        name = "error";
    }

    @Override
    public void execute(String direction) {
        commandParserProxy.sendError();
    }

    @Override
    public String getName() {
        return name;
    }
}
