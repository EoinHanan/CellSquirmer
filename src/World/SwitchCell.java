package World;

public class SwitchCell extends Cell {

    public  SwitchCell(int positionX, int positionY){
        setDescription("There's a switch here. Maybe you should press it.");

        setPositionX(positionX);

        setPositionY(positionY);

        setState(0);

        setType(4);
    }
}
