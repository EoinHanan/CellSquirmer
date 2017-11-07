package Character;

import Communication.Mediator;

/**
 * Created by EoinH on 09/10/2017.
 */
public class PlayerCharacter {
    private Position currentPosition;
    private Inventory playerInventory;

    public PlayerCharacter(Position startingPosition){
        currentPosition = startingPosition;
        playerInventory = new Inventory();
    }
    public Position getPosition(){
        return currentPosition;
    }
}