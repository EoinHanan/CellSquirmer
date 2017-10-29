package Prototype;

import java.util.Hashtable;

public class EnemyDB {

    private static Hashtable<String, Enemy> shapeMap  = new Hashtable<String, Enemy>();

    public static Enemy getEnemyID(String EnemyID) {
        Enemy cachedEnemy = shapeMap.get(EnemyID);
        return (Enemy) cachedEnemy.clone();
    }

    public static void loadCache() {
        BasicEnemy basicEnemy = new BasicEnemy();
        basicEnemy.setId("1");
        basicEnemy.setHealth(1);
        System.out.println(basicEnemy.getHealth());
        shapeMap.put(basicEnemy.getId(), basicEnemy);
        basicEnemy.Details();

        BasicEnemy basicEnemy2 = new BasicEnemy();
        basicEnemy2.setId("2");
        basicEnemy.setHealth(1);
        shapeMap.put(basicEnemy2.getId(), basicEnemy2);

        AdvancedEnemy advancedEnemy = new AdvancedEnemy();
        advancedEnemy.setId("3");
        basicEnemy.setHealth(2);
        shapeMap.put(advancedEnemy.getId(), advancedEnemy);
    }
}
