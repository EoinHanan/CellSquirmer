package Prototype;

public class PrototypeTest {
    public static void main(String[] args) {
        EnemyDB.loadCache();

        Enemy clonedEnemy = EnemyDB.getEnemyID("1");
        System.out.println("Enemy : " + clonedEnemy.getType());
        System.out.println("health : " + clonedEnemy.getHealth());

        Enemy clonedEnemy2 = EnemyDB.getEnemyID("2");
        System.out.println("Enemy : " + clonedEnemy2.getType());

        Enemy clonedEnemy3 = EnemyDB.getEnemyID("3");
        System.out.println("Enemy : " + clonedEnemy3.getType());
    }
}