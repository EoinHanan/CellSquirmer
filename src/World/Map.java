
package World;
import java.util.Random;

public class Map {
    private Cell cells[][];

    public Map(int size){
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
                enemyCount = 0;
                float chance = r.nextFloat();
                // Changed to .90 from .10 for testing
                if (chance <= .0f) {
                    createEnemy = true;
                    enemyCount++;
                }

                int n = rand.nextInt(4) + 1;
                cells[i][j] = mapLayout.makeCell(n, i, j, createEnemy, enemyCount);
            }
        }
        //System.out.println(cells[1]);

        //System.out.println(cells[1].getEnemy());

       // printAll();
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

    public void printAll(){
        for (int i =0; i < cells.length;i++){
            for (int j =0; j < cells.length;j++){
                System.out.println(i + "," + j + ": " + cells[i][j].getEnemy().getHealth());
            }
        }
    }
}