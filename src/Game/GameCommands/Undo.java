package Game.GameCommands;


import Game.GameColleague;

public class Undo implements Command {
    private String name;
    private GameColleague gameProxy;

    public Undo(GameColleague gameProxy){
        this.gameProxy = gameProxy;
        name = "undo";
    }
    @Override
    public void execute(String secondWord) {
        gameProxy.executeUndo(secondWord);
    }

    @Override
    public String getName() {
        return name;
    }
}
