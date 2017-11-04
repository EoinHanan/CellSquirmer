/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package World;

import Prototype.AdvancedEnemy;
import Prototype.BasicEnemy;
import Prototype.EnemyDB;

import java.util.Random;

/**
 *
 * @author Gerry
 */
public class TrapCell extends Cell {
    
    public  TrapCell(int positionX, int positionY, boolean createEnemy, int enemyCount){
        setDescription("You have entered into a Trap Cell. Game Over!");
        
        setPositionX(positionX);
        
        setPositionY(positionY);

        setState(-1);

        setType(2);

        if (createEnemy) {

            Random rand = new Random();
            int enemyType = rand.nextInt(1) + 1;

            if (enemyType == 1) {
                BasicEnemy basicEnemy = new BasicEnemy();
                basicEnemy.setId(Integer.toString(enemyCount));
                EnemyDB.loadBasic(basicEnemy);
                setEnemy(basicEnemy);
            } else {
                AdvancedEnemy advancedEnemy = new AdvancedEnemy();
                advancedEnemy.setId(Integer.toString(enemyCount));
                EnemyDB.loadAdvanced(advancedEnemy);
                setEnemy(advancedEnemy);

            }
        }
    }
    
}
