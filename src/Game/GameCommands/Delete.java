package Game.GameCommands;

import Game.GameProxy;

public class Delete implements Command {
    private String name;
    private GameProxy gameProxy;

    public Delete(GameProxy gameProxy){
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
