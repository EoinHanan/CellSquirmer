package Game.GameCommands;

import Game.GameProxy;

public class Update implements Command {
    private String name;
    private GameProxy gameProxy;

    public Update(GameProxy gameProxy){
        name = "update";
        this.gameProxy = gameProxy;
    }

    @Override
    public void execute(String secondWord) {
        gameProxy.executeUpdate(secondWord);
    }

    @Override
    public String getName() {
        return name;
    }
}
