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
public class RegularCell extends Cell {
    
    public  RegularCell(int positionX, int positionY){
        setDescription("Just a regular cell. There's nothing interesting here.");
        
        setPositionX(positionX);
        
        setPositionY(positionY);

        setState(0);
    }
    
}
