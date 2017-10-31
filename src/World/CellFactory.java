/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package World;

import Prototype.Enemy;

/**
 *
 * @author Gerry
 */
public class CellFactory {
    
    public Cell makeCell(int newCellType, int positionX, int positionY, boolean createEnemy){
        Cell newCell = null;
        
        switch (newCellType) {
            case 1:
                newCell = new RegularCell(positionX, positionY, createEnemy);
                break;
            case 2:
                newCell = new TrapCell(positionX, positionY, createEnemy);
                break;
            case 3:
                newCell = new GoalCell(positionX, positionY, createEnemy);
                break;
            case 4:
                newCell = new SwitchCell(positionX, positionY, createEnemy);
                break;
            default:
                return newCell;
        }
        return newCell;
    }
    
}
