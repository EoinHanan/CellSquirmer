package Interceptor;
import java.util.*;
import Character.CheckpointCaretaker;
import Character.Position;
import Game.Play;



public class Dispatcher implements Interceptor {

    public static Dispatcher dispatcher;
    ArrayList interceptors;

    public Dispatcher() {
        interceptors = new ArrayList();
    }

    public static Dispatcher getInstance() {
        if (dispatcher == null) {
            dispatcher = new Dispatcher();
        }
        return dispatcher;
    }

    public void registerInterceptor(Interceptor InterceptorObject) {
        interceptors.add(InterceptorObject);

    }

    public  void unregisterInterceptor(Interceptor InterceptorObject) {

        interceptors.remove(InterceptorObject);
    }

    //    @Override
    public void errorMessageReceiver(Context context) {
        ArrayList interceptorList;

        interceptorList = (ArrayList) this.interceptors.clone();
        context.setFinalErrorMessage(context.getErrorMessage());
        MoveRequest move = new MoveRequest(getClass().getName());

        context.setFinalErrorMessage(context.getErrorMessage());
        move.printError(context.getFinalErrorMessage());


    }

    public void updateMomento(ConcreteMomentoInterceptor play){
        CheckpointCaretaker c = play.getCheckpointCaretaker();
        Position myPosition = play.getPosition();
        play.setX(myPosition.getX(),c);
        play.setY(myPosition.getY(),c);
        play.setPosition(myPosition,c);

    }

}
