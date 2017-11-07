package Game.GameCommands;

import Game.GameProxy;

/**
 * Created by EoinH on 07/11/2017.
 */
public class Load implements Command {
    private String name;
    private GameProxy gameProxy;

    public Load(GameProxy gameProxy){
        name = "load";
        this.gameProxy = gameProxy;
    }

    @Override
    public void execute(String secondWord) {
        gameProxy.executeLoad(secondWord);
    }

    @Override
    public String getName() {
        return name;
    }
}
