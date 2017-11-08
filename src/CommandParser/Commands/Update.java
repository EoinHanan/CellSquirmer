package CommandParser.Commands;

import CommandParser.CommandParserProxy;

public class Update implements Command {
    private CommandParserProxy commandProxy;
    private String name;

    public Update(CommandParserProxy commandProxy){
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
