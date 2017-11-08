package CommandParser.Commands;


import CommandParser.CommandParserProxy;

public class Print implements Command {
    private String name;
    private CommandParserProxy commandProxy;
    public Print(CommandParserProxy commandProxy) {
        this.commandProxy = commandProxy;
        name = "print";
    }

    @Override
    public void execute(String secondWord) {
        commandProxy.executePrint();
    }

    @Override
    public String getName() {
        return name;
    }
}
