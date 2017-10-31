package Prototype;

import java.util.Hashtable;

public class EnemyDB {

    private static Hashtable<String, Enemy> shapeMap  = new Hashtable<String, Enemy>();

    public static Enemy getEnemyID(String EnemyID) {
        Enemy cachedEnemy = shapeMap.get(EnemyID);
        System.out.println(cachedEnemy);
        return (Enemy) cachedEnemy.clone();
    }

    public static void loadBasic(BasicEnemy basicEnemy) {

        shapeMap.put(basicEnemy.getId(), basicEnemy);

    }
    public static void loadAdvanced(AdvancedEnemy advancedEnemy) {

        shapeMap.put(advancedEnemy.getId(), advancedEnemy);

    }
}
