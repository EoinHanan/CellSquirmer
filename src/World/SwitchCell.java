package World;

public class SwitchCell extends Cell {

    public  SwitchCell(int positionX, int positionY, boolean createEnemy){
        setDescription("There's a switch here. Maybe you should press it.");

        setPositionX(positionX);

        setPositionY(positionY);

        setState(0);

        setType(4);

        if(createEnemy){
            //create an enemy & set it in room.

        }
    }
}
