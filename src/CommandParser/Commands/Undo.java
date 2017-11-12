package CommandParser.Commands;

import CommandParser.CommandParserColleague;

public class Undo implements Command {
    private String name;
    private  CommandParserColleague commandColleague;

    public Undo(CommandParserColleague commandProxy){
        this.commandColleague = commandProxy;
        name = "undo";
    }
    @Override
    public void execute(String secondWord) {
        commandColleague.executeUndo(secondWord);
    }

    @Override
    public String getName() {
        return name;
    }
}
