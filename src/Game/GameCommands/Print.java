package Game.GameCommands;

import Game.GameColleague;

/**
 * Created by EoinH on 07/11/2017.
 */
public class Print implements Command {
    private String name;
    private GameColleague gameProxy;

    public Print(GameColleague gameProxy){
        name = "print";
        this.gameProxy = gameProxy;
    }


    @Override
    public void execute(String contents) {
        gameProxy.executePrint();
    }

    @Override
    public String getName() {
        return name;
    }
}
