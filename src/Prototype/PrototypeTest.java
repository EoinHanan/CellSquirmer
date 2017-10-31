package Prototype;

public class PrototypeTest {
    public static void main(String[] args) {


//        EnemyDB.loadBasic();
//        BasicEnemy basicEnemy = new BasicEnemy();
//        basicEnemy.setId("1");
//        basicEnemy.setHealth(1);
//        System.out.println(basicEnemy.getHealth());
//        shapeMap.put(basicEnemy.getId(), basicEnemy);
//        basicEnemy.Details();

        BasicEnemy basicEnemy = new BasicEnemy();
        basicEnemy.setId("1");
        basicEnemy.setHealth(1);
        EnemyDB.loadBasic(basicEnemy);


        Enemy clonedEnemy = EnemyDB.getEnemyID("1");
        System.out.println("Enemy : " + clonedEnemy.getType());
        System.out.println("health : " + clonedEnemy.getHealth());

//        Enemy clonedEnemy2 = EnemyDB.getEnemyID("3");
//        System.out.println("Enemy : " + clonedEnemy2.getType());
//
//        Enemy clonedEnemy3 = EnemyDB.getEnemyID("7");
//        System.out.println("Enemy : " + clonedEnemy3.getType());
    }
}