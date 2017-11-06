package Combat;
import Communication.Message;
import World.Map;
import World.Cell;
import Prototype.Enemy;
import Character.Position;

import java.util.ArrayList;

public class Attack {
    int x, y;
    Cell currentCell;
    Enemy ourEnemy;
    int enemyCount, enemyHealth;
    ArrayList cellsEnemies = new ArrayList();
    ArrayList cellsEnemiesHealth = new ArrayList();

    public Attack(Map map){
        //x = Position.getX();
        x = 1;
        y = 1;
        System.out.println("Attack made");

        //Find out what enemies are at the current position
        currentCell = map.getCell(x, y); //Need the non-static run time map

        //Populate the enemy arraylist with enemies
        enemyCount = currentCell.getEnemyCount();
        for(int i = 0; i < enemyCount; i++){
            ourEnemy = currentCell.getEnemy();
            enemyHealth = ourEnemy.getHealth();
            enemyHealth--;
            currentCell.getEnemy().setHealth(enemyHealth);
        }
    }
}
