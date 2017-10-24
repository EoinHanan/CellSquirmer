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

    private int sizeofmap;

    public void play(int sizeofmap){
        Cell currentmap [];
        Map map = new Map();
        currentmap = map.CreateMap(sizeofmap);
        int i = 0;
        int state = 0;
        Position myPosition = new Position(0,0);
        CheckpointCaretaker c = new CheckpointCaretaker();
        while(state != -1 || state != 1){


            //if recieved message is go, work through Move Class

            //else if recieved message is investigate, work through State Class

        }

    }

    
}
