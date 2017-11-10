package Game.GameCommands;

import Game.GameColleague;

public class Delete implements Command {
    private String name;
    private GameColleague gameProxy;

    public Delete(GameColleague gameProxy){
        name = "delete";
        this.gameProxy = gameProxy;
    }

    @Override
    public void execute(String secondWord) {
        gameProxy.executeDelete(secondWord);
    }

    @Override
    public String getName() {
        return name;
    }
}
