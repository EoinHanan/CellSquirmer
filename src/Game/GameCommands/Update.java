package Game.GameCommands;

import Game.GameColleague;

public class Update implements Command {
    private String name;
    private GameColleague gameProxy;

    public Update(GameColleague gameProxy){
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
