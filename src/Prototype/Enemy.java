package Prototype;

public abstract class Enemy implements Cloneable {

    private String id;
    protected int health;
    protected String type;

    abstract void Details();

    public String getType(){
        return type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public Object clone() {
        Object clone = null;

        try {
            clone = super.clone();
        }

        catch (CloneNotSupportedException error) {
            error.printStackTrace();
        }

        return clone;
    }
}