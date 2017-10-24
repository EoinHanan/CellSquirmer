/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import World.Map;
import World.Cell;
import Character.*;

/**
 *
 * @author Gerry
 */
public class Play {

    private int sizeOfMap;
    private int cX;
    private int cY;

    public Play(int sizeOfMap, int x, int y) {
        this.cX = x;
        this.cY = y;
        this.sizeOfMap = sizeOfMap;

    }

    public void setSizeOfMap(int sizeOfMap) {
        this.sizeOfMap = sizeOfMap;
    }

    public void start() {
        Cell currentmap[];
        Map map = new Map();
        currentmap = map.CreateMap(sizeOfMap);
        int i = 0;
        int state = 0;
        Position myPosition = new Position(cX, cY);
        CheckpointCaretaker c = new CheckpointCaretaker();
        while (state != -1 || state != 1) {
            cX = c.getXValue();
            cY = c.getYValue();


            //if recieved message is go, work through Move Class

            //else if recieved message is investigate, work through State Class

        }
    }
}
