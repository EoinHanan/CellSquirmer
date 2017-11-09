package Game.Startup.Commands;

import Game.Startup.Menu;

/**
 * Created by EoinH on 08/11/2017.
 */
public class Error implements Command{
    private String name;
    private Menu menu;

    public Error(Menu menu) {
        this.menu = menu;
        name = "error";
    }

    @Override
    public void execute(String secondWord) {
        menu.sendError(secondWord);
    }

    @Override
    public String getName() {
        return name;
    }
}
