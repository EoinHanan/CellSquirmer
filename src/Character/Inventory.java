package Character;
import World.Item;

/**
 * Created by KieranF on 04/10/2017.
 */

public class Inventory {
    private Item[] inventory;
    private int itemsHeld = 0;

    public Inventory(){
        inventory = new Item[10];
    }

    public void addItem(Item myItem){
       inventory[itemsHeld] = myItem;
       itemsHeld++;
    }

    public void removeItem(Item myItem){
        for(int i=0; i < itemsHeld; i++){
            if(inventory[i] == myItem){
                inventory[i] = new Item();
            }
        }
    }

    public void describeInventory(){
        String inventoryDescription = "Your inventory is:";
        for(int i=0; i < itemsHeld; i++){
            inventoryDescription += " " + inventory[i].getShortDescription();
        }
    }

}
