package World;

import Prototype.AdvancedEnemy;
import Prototype.BasicEnemy;
import Prototype.EnemyDB;

import java.util.Random;

public class SwitchCell extends Cell {

    public  SwitchCell(int positionX, int positionY, boolean createEnemy, int enemyCount){
        setDescription("There's a switch here. Maybe you should press it.");

        setPositionX(positionX);

        setPositionY(positionY);

        setState(0);

        setType(4);

        if (createEnemy) {
            //System.out.println("We're creating an enemy in switch");
            Random rand = new Random();
            int enemyType = rand.nextInt(1) + 1;
            setEnemyCount(enemyCount);

            if (enemyType == 1) {
                BasicEnemy basicEnemy = new BasicEnemy();
                basicEnemy.setId(Integer.toString(enemyCount));
                EnemyDB.loadBasic(basicEnemy);
                setEnemy(basicEnemy);
                setIsEnemy(true);
            } else {
                AdvancedEnemy advancedEnemy = new AdvancedEnemy();
                advancedEnemy.setId(Integer.toString(enemyCount));
                EnemyDB.loadAdvanced(advancedEnemy);
                setEnemy(advancedEnemy);
                setIsEnemy(true);
            }
        }
    }
}
