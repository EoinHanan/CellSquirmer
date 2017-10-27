package Interceptor;
import java.util.*;


public class MoveDispatcher implements MoveInterceptor {

    private static MoveDispatcher dispatcher;
    ArrayList interceptors;

    private MoveDispatcher() {
        interceptors = new ArrayList();
    }

    public static MoveDispatcher getInstance() {
        if (dispatcher == null) {
            dispatcher = new MoveDispatcher();
        }
        return dispatcher;
    }

    public void registerErrorMessageInterceptor(MoveInterceptor InterceptorObject) {
        interceptors.add(InterceptorObject);

    }

    public  void unregisterErrorMessageInterceptor(MoveInterceptor InterceptorObject) {

        interceptors.remove(InterceptorObject);
    }

    @Override
    public void errorMessageReceiver(MoveRequest context) {
        ArrayList interceptorList;

        interceptorList = (ArrayList) this.interceptors.clone();
        context.setFinalErrorMessage(context.getErrorMessage());
        Move move = new Move(getClass().getName());

        context.setFinalErrorMessage(context.getErrorMessage());
        move.printError(context.getFinalErrorMessage());


    }
}
