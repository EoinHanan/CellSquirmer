package Game.Startup.Commands;

import Game.Startup.Menu;

/**
 * Created by EoinH on 08/11/2017.
 */
public class NewGameCommand implements Command{
    private String name;
    private Menu menu;

    public NewGameCommand(Menu menu) {
        this.menu = menu;
        name = "newgame";
    }

    @Override
    public void execute(String secondWord) {
        menu.startNewGame(secondWord);
    }

    @Override
    public String getName() {
        return name;
    }
}
