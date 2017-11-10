package Game.GameCommands;

import Game.GameColleague;

/**
 * Created by EoinH on 07/11/2017.
 */
public class Go implements Command {
    private String name;
    private GameColleague gameProxy;

    public Go(GameColleague gameProxy){
        name = "go";
        this.gameProxy=gameProxy;
    }

    @Override
    public void execute(String secondWord) {
        gameProxy.executeGo(secondWord);
    }

    @Override
    public String getName() {
        return name;
    }
}