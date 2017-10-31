package Prototype;

public class AdvancedEnemy extends Enemy {

    public AdvancedEnemy(){
        type = "AdvancedEnemy";
        health = 2;
    }

    @Override
    public void Details() {
        System.out.println("Inside AdvancedEnemy::AdvancedEnemy() method.");
    }
}


