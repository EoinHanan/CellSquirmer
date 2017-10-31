
package World;
import java.util.Random;

public class Map {

    private Map map;
    
    public Cell[] CreateMap(int size)
    {
        CellFactory mapLayout = new CellFactory();
        Cell[] gameMap = new Cell[size + 1];
        Random rand = new Random();
        Random r = new Random();
        boolean createEnemy;
        for(int i = 0; i <= size; i++)
        {
            createEnemy = false;
            float chance = r.nextFloat();
            if(chance <=  0.10f){
                createEnemy = true;
            }
            int n = rand.nextInt(4) + 1;
            gameMap[i] = mapLayout.makeCell(n, 0, i, createEnemy);
        }
        return gameMap;
    }
    
}
