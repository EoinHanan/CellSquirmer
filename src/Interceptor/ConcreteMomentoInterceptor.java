package Interceptor;
import Character.CheckpointCaretaker;
import Game.Play;
import Character.Position;
import javafx.geometry.Pos;

/**
 * Created by Patrick on 07/11/2017.
 */
public class ConcreteMomentoInterceptor implements ContextMomento {


    private Play object;
    private Position positionObject;
    private int x;
    private int y;




    public ConcreteMomentoInterceptor(Play play, Position position) {
        this.object = play;
        this.positionObject = position;

    }


    @Override
    public CheckpointCaretaker getCheckpointCaretaker() {
        return object.getCaretaker();
    }


    public Position getPosition(){
        return positionObject;
    }

    public void setPosition(Position position, CheckpointCaretaker c){

        this.positionObject = position;
        c.setPosition(position);


    }

    public void setX(int X, CheckpointCaretaker c){
        c.setXValue(X);

        x = X; }

    public void setY(int Y, CheckpointCaretaker c ){
        c.setYValue(Y);
        y = Y;}

    public int getX(){ return positionObject.getX(); }

    public int getY(){ return positionObject.getY();}



}


