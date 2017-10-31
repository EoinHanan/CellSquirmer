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
                newCell = new RegularCell(positionX, positionY);
                break;
            case 2:
                newCell = new TrapCell(positionX, positionY);
                break;
            case 3:
                newCell = new GoalCell(positionX, positionY);
                break;
            case 4:
                newCell = new SwitchCell(positionX, positionY);
                break;
            default:
                return newCell;
        }
        return newCell;
    }
    
}
