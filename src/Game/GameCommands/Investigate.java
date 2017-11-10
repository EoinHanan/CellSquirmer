package Game.GameCommands;

import Game.GameColleague;

/**
 * Created by EoinH on 07/11/2017.
 */
public class Investigate implements Command {
    private String name;
    private GameColleague gameProxy;

    public Investigate(GameColleague gameProxy){
        name = "investigate";
        this.gameProxy = gameProxy;
    }

    @Override
    public void execute(String secondWord) {
        gameProxy.executeInvestigate();
    }

    @Override
    public String getName() {
        return name;
    }
}
