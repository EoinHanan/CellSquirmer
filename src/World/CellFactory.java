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
public class CellFactory {
    
    public Cell makeCell(int newCellType, int positionX, int positionY){
        Cell newCell = null;
        
        switch (newCellType) {
            case 1:
                return new RegularCell(positionX, positionY);  
            case 2:
                return new TrapCell(positionX, positionY);
            case 3:
                return new GoalCell(positionX, positionY);
            default:
                return newCell;
        }
    }
    
}
