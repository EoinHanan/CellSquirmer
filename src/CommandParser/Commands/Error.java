package CommandParser.Commands;

import CommandParser.CommandParserColleague;

public class Error implements Command {
    private CommandParserColleague commandParserProxy;
    private String name;

    public Error(CommandParserColleague commandProxy) {
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
