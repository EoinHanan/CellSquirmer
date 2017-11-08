package Combat;
import Prototype.Enemy;

public class Attack {
    int enemyHealth;

    public Attack(Enemy enemy){
        enemyHealth = enemy.getHealth();
    }
}
