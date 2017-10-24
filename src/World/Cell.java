/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package World;

/**
 *
 * @author Gerry
 */
public abstract class Cell {
    private int positionX;
    private int positionY;
    private int state;
    private String description;
    
    
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
    
}
