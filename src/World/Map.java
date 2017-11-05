
package World;
import java.util.Random;
import Prototype.EnemyDB;

public class Map {
    private Cell cells[][];

    private static Map firstInstance = null;

    private Map(){}

    public static Map getInstance(){
        if (firstInstance == null){
            firstInstance = new Map();
            System.out.println("New Map created");
        }
        else
            System.out.println("Here is the same old map");
        return firstInstance;
    }

    public void createMap(int size)
    {
        cells = new Cell[size][size];
        CellFactory mapLayout = new CellFactory();
        Random rand = new Random();
        Random r = new Random();
        boolean createEnemy;
        int enemyCount = 0;
        for(int i = 0; i < size; i++)
        {
            for(int j = 0; j < size; j++) {
                createEnemy = false;
                float chance = r.nextFloat();
                // Changed to .90 from .10 for testing
                if (chance <= 0.90f) {
                    createEnemy = true;
                    enemyCount++;
                }
                int n = rand.nextInt(4) + 1;
                cells[i][j] = mapLayout.makeCell(n, 0, i, createEnemy, enemyCount);
            }
        }
        //System.out.println(cells[1]);

        //System.out.println(cells[1].getEnemy());
    }

    public int getSize(){
        return cells.length;
    }

    public Cell getCell(int x, int y){
        return cells[x][y];
    }

    public void changeMap(Cell[][] cells){
        this.cells = cells;
    }
}