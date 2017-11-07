package Interceptor;
import Character.CheckpointCaretaker;

/**
 * Created by Patrick on 07/11/2017.
 */
public interface ContextMomento {

    CheckpointCaretaker getErrorMessage();

    void setFinalErrorMessage(String finalMessage);

    CheckpointCaretaker getFinalErrorMessage();

    void setX(int X);

    void setY(int Y);

    int getX();

    int getY();
}
