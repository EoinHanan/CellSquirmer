package Character;
import java.util.ArrayList;

class Caretaker {

    // Where all mementos are saved

    ArrayList<Position> savedPositions = new ArrayList<Position>();

    // Adds position to the ArrayList

    public void addCheckpoint(Position m) { savedPositions.add(m); }

    // Gets the memento requested from the ArrayList

    public Position getCheckpoint(int index) { return savedPositions.get(index); }
}
