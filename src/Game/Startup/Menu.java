package Game.Startup;

import Facade.MapMapper;
import Game.Play;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by EoinH on 08/11/2017.
 */
public class Menu {
    private Play play;
    private String mapName;
    private Printer printer;
    private Parser parser;
    private ArrayList<String> mapNames;
    private TakeInput takeInput;

    public Menu() throws SQLException {
        printer = new Printer();
        parser = new Parser(this);
        takeInput = new TakeInput();
        mapNames = loadMapNames();
    }

    private ArrayList<String> loadMapNames() throws SQLException {
        ArrayList<String> mapNames = new ArrayList<>();
        MapMapper mapMapper = new MapMapper();
        mapNames = mapMapper.getMapNames();
        return mapNames;
    }

    public void run(){
        String input;
        while (true) {
            input = takeInput.userinput();
            parser.validate(input);
        }
    }


    public void sendError(String errorMessage){
        printer.print(errorMessage);
    }

    public void startNewGame(String mapName) {
        play = new Play(10,1,1, mapName,false);
        play.start();
    }

    public void loadGame(String secondWord) {
        boolean found = false;
        for (int i =0;  i < mapNames.size() && !found;i++)
            if (mapNames.get(i).equals(secondWord))
                found = true;
        if (found) {
            play = new Play(10, 1, 1, mapName, true);
            play.start();
        }
        else
            sendError("No save by that name exists");
    }
}
