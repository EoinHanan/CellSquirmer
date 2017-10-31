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
public class GoalCell extends Cell {
    
    public  GoalCell(int positionX, int positionY, boolean createEnemy){
        setDescription("You have found the goal. Congratulations!");
        
        setPositionX(positionX);
        
        setPositionY(positionY);

        setState(1);

        setType(3);

        if(createEnemy){
            //create an enemy & set it in room.

        }
    }
    
    
    
}
