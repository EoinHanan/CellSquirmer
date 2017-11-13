package Prototype;

import java.util.Hashtable;

public class EnemyDB {

    private static Hashtable<String, Enemy> enemyMapping  = new Hashtable<String, Enemy>();

    public static Enemy getEnemyID(String EnemyID) {
        Enemy cachedEnemy = enemyMapping.get(EnemyID);
        System.out.println(cachedEnemy);
        return (Enemy) cachedEnemy.clone();
    }

    public static void loadBasic(BasicEnemy basicEnemy) {

        enemyMapping.put(basicEnemy.getId(), basicEnemy);

    }
    public static void loadAdvanced(AdvancedEnemy advancedEnemy) {

        enemyMapping.put(advancedEnemy.getId(), advancedEnemy);

    }
}
