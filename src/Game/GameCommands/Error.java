package Game.GameCommands;

import Game.GameColleague;

/**
 * Created by EoinH on 07/11/2017.
 */
public class Error implements Command {
    private String name;
    private GameColleague gameProxy;

    public Error(GameColleague gameProxy){
        name = "error";
        this.gameProxy=gameProxy;
    }


    @Override
    public void execute(String secondWord) {

    }

    @Override
    public String getName() {
        return name;
    }
}
