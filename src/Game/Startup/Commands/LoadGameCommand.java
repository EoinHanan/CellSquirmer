package Game.Startup.Commands;

import CommandParser.Commands.Load;
import Game.Startup.Menu;

/**
 * Created by EoinH on 08/11/2017.
 */
public class LoadGameCommand implements Command{
    private String name;
    private Menu menu;

    public LoadGameCommand(Menu menu) {
        this.menu = menu;
        name = "loadgame";
    }

    @Override
    public void execute(String secondWord) {
        menu.loadGame(secondWord);
    }

    @Override
    public String getName() {
        return name;
    }
}
