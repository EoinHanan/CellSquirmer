package CommandParser.Commands;


import CommandParser.CommandParserColleague;

public class Print implements Command {
    private String name;
    private CommandParserColleague commandProxy;
    public Print(CommandParserColleague commandProxy) {
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
