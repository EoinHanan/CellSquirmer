package Game.GameCommands;

import CommandParser.CommandParserProxy;
import Game.GameProxy;

/**
 * Created by EoinH on 07/11/2017.
 */
public class Go implements Command {
    private String name;
    private GameProxy gameProxy;

    public Go(GameProxy gameProxy){
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
