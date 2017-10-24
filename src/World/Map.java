
package World;
import java.util.Random;

public class Map {

    private Map map;
    
    public Cell[] CreateMap(int size)
    {
        CellFactory mapLayout = new CellFactory();
        Cell[] gameMap = new Cell[size + 1];
        for(int i = 0; i <= size; i++)
        { 
            Random rand = new Random();
            int n = rand.nextInt(3) + 1;
            gameMap[i] = mapLayout.makeCell(n, 0, i);
        }
        return gameMap;
    }
    
}
