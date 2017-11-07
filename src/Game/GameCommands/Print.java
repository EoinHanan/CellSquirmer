package Game.GameCommands;

import Game.GameProxy;

/**
 * Created by EoinH on 07/11/2017.
 */
public class Print implements Command {
    private String name;
    private GameProxy gameProxy;

    public Print(GameProxy gameProxy){
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
