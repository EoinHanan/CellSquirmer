package Game.GameCommands;

import Game.GameProxy;

/**
 * Created by EoinH on 07/11/2017.
 */
public class Error implements Command {
    private String name;
    private GameProxy gameProxy;

    public Error(GameProxy gameProxy){
        name = "error";
        this.gameProxy=gameProxy;
    }


    @Override
    public void execute(String secondWord) {

    }

    @Override
    public String getName() {
        return null;
    }
}
