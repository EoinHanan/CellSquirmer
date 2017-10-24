package Character;

import Communication.Mediator;

/**
 * Created by EoinH on 09/10/2017.
 */
public class PlayerCharacter {
    public Position currentPosition;
    public Inventory playerInventory;
    private static CharacterProxy commandProxy;

    public PlayerCharacter(Position startingPosition, Mediator mediator){
        currentPosition = startingPosition;
        playerInventory = new Inventory();
        commandProxy = new CharacterProxy(mediator);
    }
}