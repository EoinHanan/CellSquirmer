package Interceptor;
import java.util.*;
import Character.CheckpointCaretaker;
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

    public void registerErrorMessageInterceptor(Interceptor InterceptorObject) {
        interceptors.add(InterceptorObject);

    }

    public  void unregisterErrorMessageInterceptor(Interceptor InterceptorObject) {

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

    public void updateMomento(ConcreteMomentoInterceptor context){
        System.out.println("update Momento");
//        CheckpointCaretaker cartakerObject = play.getCaretaker();
//        int cX = cartakerObject.getXValue();
//        int cY = cartakerObject.getYValue();
//        System.out.println(context.getX());
//        System.out.println(context.getY());
//        System.out.println(context.getXValue());
//        System.out.println(context.getYValue());
        System.out.println(context.getX());
        System.out.println(context.getY());
        context.setX(context.getX());
        context.setY(context.getY());
//        c.setYValue(cY);

    }

}
