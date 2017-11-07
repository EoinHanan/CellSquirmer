package Combat;
import Combat.AttackParser.Parser;
import Communication.Message;
import Prototype.Enemy;

import java.util.Scanner;

public class Attack {
    int enemyHealth;
    //boolean hasAttacked = false;

    public Attack(Enemy enemy){
        //Get an enemies health, decrement it and set it as the new health of the enemy
        enemyHealth = enemy.getHealth();
    }
     public void damaged(){
         enemyHealth--;
     }
    public int getHealth(){
        return enemyHealth;
    }

}
