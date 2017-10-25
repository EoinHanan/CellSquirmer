import Game.Play;
import World.Cell;

/**
 * Created by EoinH on 28/09/2017.
 */
public class Main {
    public static void main(String [] args){
        Cell map [] = new Cell[10];
        Play play = new Play(10,1,1, map);
        play.start();
    }
}
