package Prototype;

public class BasicEnemy extends Enemy {

    public BasicEnemy(){
        type = "BasicEnemy";
    }

    @Override
    public void Details() {
        System.out.println("Inside BasicEnemy::basicDetails() method.");
    }
}
