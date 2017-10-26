import Game.Play;
import World.Cell;
import World.Map;

/**
 * Created by EoinH on 28/09/2017.
 */
public class Main {
    public static void main(String [] args){
        Map map = new Map();
        Cell currentMap [] = new Cell[10];
        currentMap = map.CreateMap(10);
        Play play = new Play(10,1,1, currentMap);
        play.start();
    }
}
