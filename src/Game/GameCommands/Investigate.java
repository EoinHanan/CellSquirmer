package Game.GameCommands;

import Game.GameProxy;

/**
 * Created by EoinH on 07/11/2017.
 */
public class Investigate implements Command {
    private String name;
    private GameProxy gameProxy;

    public Investigate(GameProxy gameProxy){
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
