
package World;
import java.util.Random;
import Prototype.EnemyDB;

public class Map {

    private Map map;
    
    public Cell[] CreateMap(int size)
    {
        CellFactory mapLayout = new CellFactory();
        Cell[] gameMap = new Cell[size + 1];
        Random rand = new Random();
        Random r = new Random();
        boolean createEnemy;
        int enemyCount = 0;
        for(int i = 0; i <= size; i++)
        {
            createEnemy = false;
            float chance = r.nextFloat();
            // Changed to .90 from .10 for testing
            if(chance <=  0.90f){
                createEnemy = true;
                enemyCount++;
            }
            int n = rand.nextInt(4) + 1;
            gameMap[i] = mapLayout.makeCell(n, 0, i, createEnemy, enemyCount);
        }
        System.out.println(gameMap[1]);

        System.out.println(gameMap[1].getEnemy());
        return gameMap;
    }
    
}
