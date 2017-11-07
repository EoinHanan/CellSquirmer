package Game.GameCommands;

import Game.GameProxy;

/**
 * Created by EoinH on 07/11/2017.
 */
public class Save implements Command {
    private String name;
    private GameProxy gameProxy;

    public Save(GameProxy gameProxy){
        name = "save";
        this.gameProxy = gameProxy;
    }

    @Override
    public void execute(String secondWord) {
        gameProxy.executeSave(secondWord);
    }

    @Override
    public String getName() {
        return name;
    }
}
