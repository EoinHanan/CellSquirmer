package Prototype;

public class AdvancedEnemy extends Enemy {

    public AdvancedEnemy(){
        type = "AdvancedEnemy";
    }

    @Override
    public void Details() {
        System.out.println("Inside AdvancedEnemy::AdvancedEnemy() method.");
    }
}


