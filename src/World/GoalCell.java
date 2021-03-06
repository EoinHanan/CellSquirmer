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
public class GoalCell extends Cell {

    public GoalCell(int positionX, int positionY, boolean createEnemy, int enemyCount) {
        setDescription("You have found the goal. Congratulations!");

        setPositionX(positionX);

        setPositionY(positionY);

        setState(1);

        setType(3);

        if (createEnemy) {
            //System.out.println("We're creating an enemy in goal");
            Random rand = new Random();
            int enemyType = rand.nextInt(1) + 1;
            setEnemyCount(enemyCount);

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
