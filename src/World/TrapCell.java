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
public class TrapCell extends Cell {
    
    public  TrapCell(int positionX, int positionY){
        setDescription("You have entered into a Trap Cell. Game Over!");
        
        setPositionX(positionX);
        
        setPositionY(positionY);

        setState(-1);
    }
    
}
