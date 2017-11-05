/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package World;

import Prototype.Enemy;
import Prototype.EnemyDB;

/**
 *
 * @author Gerry
 */
public abstract class Cell {
    private int positionX;
    private int positionY;
    private int state;
    private String description;
    private int type;
    private Enemy enemy;
    private boolean isEnemy;
    private int enemyCount;
    
    
    public int getPositionX(){
        return positionX;
    }
    
    public void setPositionX(int newPositionX){
        positionX = newPositionX;
    }
    
    public int getPositionY(){
        return positionY;
    }
    
    public void setPositionY(int newPositionY){
        positionY = newPositionY;
    }
    
    public String getDescription(){
        return description;
    }
    
    public void setDescription(String newDescription){
        description = newDescription;
    }

    public int getState(){
        return state;
    }

    public void setState(int newState){
        state = newState;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public void setIsEnemy(boolean isEnemy){
        this.isEnemy = isEnemy;
    }

    public boolean getIsEnemy() {
        return isEnemy;
    }

    public int getEnemyCount() {
        return enemyCount;
    }

    public void setEnemyCount(int enemyCount) {
        this.enemyCount = enemyCount;
    }
}
