package Interceptor;
import Character.CheckpointCaretaker;
import Character.Position;
import Game.Play;


/**
 * Created by Patrick on 07/11/2017.
 */
public interface ContextMomento {

    CheckpointCaretaker getCheckpointCaretaker();

    Position getPosition();

    void setPosition(Position play, CheckpointCaretaker c);


    void setX(int X, CheckpointCaretaker c);

    void setY(int Y, CheckpointCaretaker c);
}
