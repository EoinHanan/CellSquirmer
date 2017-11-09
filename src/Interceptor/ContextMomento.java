package Interceptor;
import Character.CheckpointCaretaker;
import Character.Position;
import Game.Play;


/**
 * Created by Patrick on 07/11/2017.
 */
public interface ContextMomento {

    Play getErrorMessage();

    void setFinalErrorMessage(String finalMessage);

    CheckpointCaretaker getCheckpointCaretaker();

    Position getPosition();

    void setPosition(Position play,CheckpointCaretaker c);


    void setX(int X);

    void setY(int Y);

    int getX();

    int getY();
}
