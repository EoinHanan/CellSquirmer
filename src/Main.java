import Game.Play;
import Game.Startup.Menu;
import World.Cell;
import World.Map;

import java.sql.SQLException;

/**
 * Created by EoinH on 28/09/2017.
 */
public class Main {
    public static void main(String [] args){
        try {
            Menu startMenu = new Menu();
            startMenu.run();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
